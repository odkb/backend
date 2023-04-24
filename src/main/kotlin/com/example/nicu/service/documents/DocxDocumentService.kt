package com.example.nicu.service.documents

import com.example.nicu.DtoFieldMap
import com.example.nicu.dto.documents.DocumentDto
import jakarta.xml.bind.JAXBElement
import org.docx4j.Docx4J
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import org.docx4j.wml.*
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.math.BigInteger


@Service
class DocxDocumentService {
    fun getDocumentAsWord(fileName: String, dto: DocumentDto): ByteArrayOutputStream {
        val fileResource = "templates/$fileName.docx"
        val inputStream = javaClass.classLoader.getResourceAsStream(fileResource)
            ?: throw FileNotFoundException("Resource file not found: $fileResource")
        val sourceDocx = Docx4J.load(inputStream)
        val byteArrayOutputStream = ByteArrayOutputStream().also { sourceDocx.save(it) }

        val targetDocx = WordprocessingMLPackage.load(ByteArrayInputStream(byteArrayOutputStream.toByteArray()))
        val sourceBody = sourceDocx.mainDocumentPart.contents.body
        val targetBody = targetDocx.mainDocumentPart.contents.body.also { it.content.clear() }


        for (sourceContent in sourceBody.content) {
            when (val unwrappedContent = if (sourceContent is JAXBElement<*>) sourceContent.value else sourceContent) {
                is P -> fillParagraph(unwrappedContent, dto, targetBody)
                is Tbl -> fillTable(unwrappedContent, dto, targetBody)
            }
        }

        val outputStream = ByteArrayOutputStream()
        Docx4J.save(targetDocx, outputStream)
        return outputStream
    }

    private fun fillParagraph(
        unwrappedContent: Any,
        dto: DocumentDto,
        targetBody: Body
    ) {
        val factory = ObjectFactory.get()
        val updatedText = replacePlaceholdersWithValues(unwrappedContent.toString(), dto)
            ?: return
        val targetParagraph = factory.addParagraph(updatedText)
        targetBody.content.add(targetParagraph)
    }

    private fun ObjectFactory.addParagraph(updatedText: String): P {
        val targetText = createText()
            .apply { value = updatedText }
        val targetRun = createR()
            .apply { content.add(targetText) }
        return createP()
            .apply { content.add(targetRun) }
    }

    private fun fillTable(
        unwrappedContent: Tbl,
        dto: DocumentDto,
        targetBody: Body
    ) {
        val factory = ObjectFactory.get()
        val border = factory.createBorder()

        val targetTable = factory.createTable(border)

        for (sourceRow in unwrappedContent.content.filterIsInstance<Tr>()) {
            val targetRow = factory.createTr()
            for (wrappedCell in sourceRow.content.filterIsInstance<JAXBElement<*>>()) {
                if (wrappedCell.value is Tc) {
                    val sourceCell = wrappedCell.value as Tc
                    val updatedText =
                        replacePlaceholdersWithValues(sourceCell.content.filterIsInstance<P>().joinToString(), dto)
                            ?: continue

                    val targetCell = factory.createTableCell(border, updatedText)
                    targetRow.content.add(targetCell)
                }
            }
            targetTable.content.add(targetRow)
        }

        targetBody.content.add(targetTable)
    }

    private fun ObjectFactory.createTable(border: CTBorder): Tbl {
        val tblBorders = createTblBorders().apply {
            top = border
            left = border
            bottom = border
            right = border
        }
        val tblPr = createTblPr().apply { this.tblBorders = tblBorders }
        return createTbl().apply { this.tblPr = tblPr }
    }

    private fun ObjectFactory.createTableCell(border: CTBorder, content: String): Tc {
        val tcBorders = createTcPrInnerTcBorders().apply {
            top = border
            left = border
            bottom = border
            right = border
        }
        val tcPr = createTcPr().apply { this.tcBorders = tcBorders }
        return createTc().apply {
            this.content.add(this@createTableCell.addParagraph(content))
            this.tcPr = tcPr
        }
    }

    private fun ObjectFactory.createBorder(): CTBorder {
        return createCTBorder().apply {
            color = "auto"
            sz = BigInteger.valueOf(4)
            `val` = STBorder.SINGLE
        }
    }

    private fun replacePlaceholdersWithValues(textValue: String, dto: DocumentDto): String? {
        val regex = Regex("""\$\{([^}]+)}""")
        var success = true
        val updatedText = regex.replace(textValue) { matchResult ->
            val placeholder = matchResult.groupValues[1]
            val replacement = getReplacementForPlaceholder(placeholder, dto)
            if (replacement == null) {
                success = false
                ""
            } else {
                replacement
            }
        }
        return if (success) updatedText else null
    }

    private fun getReplacementForPlaceholder(placeholder: String, dto: DocumentDto): String? {
        val (parentFieldName, childPlaceholderName) = parsePlaceholder(placeholder)

        return if (childPlaceholderName == null) {
            dto.getFieldValue(parentFieldName)
        } else {
            dto.getFieldValue(parentFieldName)
                .takeIf { it != DtoFieldMap.EMPTY_FIELD_VALUE }?.let { dto.getFieldValue(childPlaceholderName) }
        }
    }

    private fun parsePlaceholder(placeholder: String): Pair<String, String?> {
        val placeholderParts = placeholder.split(">")
        val parentFieldName = placeholderParts.first()
        val childPlaceholderName = if (placeholderParts.size == 2) placeholderParts.last() else null
        return parentFieldName to childPlaceholderName
    }
}