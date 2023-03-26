package com.example.nicu.service.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.DocsDto
import jakarta.xml.bind.JAXBElement
import org.docx4j.Docx4J
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import org.docx4j.wml.*
import org.docx4j.wml.TcPrInner.TcBorders
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.math.BigInteger


@Service
class PrimaryExaminationService {
    fun fillDocument(inputStream: InputStream, dto: DocsDto): ByteArrayOutputStream {
        val sourceDocx = Docx4J.load(inputStream)
        val byteArrayOutputStream = ByteArrayOutputStream()
        sourceDocx.save(byteArrayOutputStream)
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
        dto: DocsDto,
        targetBody: Body
    ) {
        val updatedText = searchRegex(unwrappedContent.toString(), dto)
        val factory = ObjectFactory.get()
        val targetParagraph = addParagraph(factory, updatedText)
        targetBody.content.add(targetParagraph)
    }

    private fun fillTable(
        unwrappedContent: Tbl,
        dto: DocsDto,
        targetBody: Body
    ) {
        val factory = ObjectFactory.get()
        val targetTable = factory.createTbl()
        val tblPr = factory.createTblPr()
        val tblBorders = factory.createTblBorders()
        setBorders(factory, tblBorders)
        tblPr.tblBorders = tblBorders
        for (sourceRow in unwrappedContent.content.filterIsInstance<Tr>()) {
            val targetRow = factory.createTr()
            for (wrappedCell in sourceRow.content) {
                if (wrappedCell is JAXBElement<*> && wrappedCell.value is Tc) {
                    val sourceCell = wrappedCell.value as Tc
                    val targetCell = factory.createTc()

                    val tcPr = factory.createTcPr()
                    val tcBorders = factory.createTcPrInnerTcBorders()
                    setBorders(factory, tcBorders)
                    tcPr.tcBorders = tcBorders

                    val updatedText =
                        searchRegex(sourceCell.content.filterIsInstance<P>().joinToString(), dto)
                    val targetParagraph = addParagraph(factory, updatedText)
                    targetCell.content.add(targetParagraph)

                    targetCell.tcPr = tcPr
                    targetRow.content.add(targetCell)
                }
            }
            targetTable.content.add(targetRow)
        }
        targetTable.tblPr = tblPr
        targetBody.content.add(targetTable)
    }

    private fun addParagraph(factory: ObjectFactory, updatedText: String): P {
        val targetParagraph = factory.createP()
        val targetRun = factory.createR()
        val targetText = factory.createText()
        targetText.value = updatedText
        targetRun.content.add(targetText)
        targetParagraph.content.add(targetRun)
        return targetParagraph
    }

    private fun setBorders(factory: ObjectFactory, borders: Any) {
        val tblBorder = factory.createCTBorder()
        tblBorder.color = "auto"
        tblBorder.sz = BigInteger.valueOf(4)
        tblBorder.`val` = STBorder.SINGLE

        if (borders is TblBorders) {
            borders.top = tblBorder
            borders.left = tblBorder
            borders.bottom = tblBorder
            borders.right = tblBorder
        } else if (borders is TcBorders) {
            borders.top = tblBorder
            borders.left = tblBorder
            borders.bottom = tblBorder
            borders.right = tblBorder
        }
    }

    private fun searchRegex(textValue: String, dto: DocsDto): String {
        val regex = Regex("""\$\{([^}]+)}""")
        val updatedText = regex.replace(textValue) { matchResult ->
            val placeholder = matchResult.groupValues[1]
            dto.getFieldValue(placeholder)
        }
        return updatedText
    }
}