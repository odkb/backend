package com.example.nicu.service.documents

import com.example.nicu.DtoFieldMap
import com.example.nicu.dto.documents.DocumentDto
import org.docx4j.convert.`in`.xhtml.XHTMLImporterImpl
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream

@Service
class DocumentHandler {
    fun getDocumentAsWord(fileName: String, dto: DocumentDto): ByteArrayOutputStream {
        val fileResource = "templates/$fileName.html"
        val htmlTemplate = ClassPathResource(fileResource).inputStream.bufferedReader().use { it.readText() }
        val xhtmlWithReplacedText = parseHtml(htmlTemplate)
        for (element in xhtmlWithReplacedText.select("*")) {
            if (element.ownText().isNotEmpty()) {
                for (node in element.textNodes()) {
                    node.text(dto.getReplaceTextForPlaceholders(node.text()) ?: "")
                }
            }
        }

        val wordMLPackage = convertXhtmlToDocx(xhtmlWithReplacedText.html())
        val byteArrayOutputStream = ByteArrayOutputStream()
        wordMLPackage.save(byteArrayOutputStream)
        return byteArrayOutputStream
    }

    private fun convertXhtmlToDocx(xhtml: String): WordprocessingMLPackage {
        val wordMLPackage = WordprocessingMLPackage.createPackage()
        val xhtmlImporter = XHTMLImporterImpl(wordMLPackage)
        wordMLPackage.mainDocumentPart.content.addAll(xhtmlImporter.convert(xhtml, null))
        return wordMLPackage
    }

    private fun parseHtml(html: String): Document {
        val document: Document = Jsoup.parse(html)
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml)
        return document
    }

    private fun DocumentDto.getReplaceTextForPlaceholders(textValue: String): String? {
        val regex = Regex("""\$\{([^}]+)}""")
        var success = true
        val updatedText = regex.replace(textValue) { matchResult ->
            val placeholder = matchResult.groupValues[1]
            val replacement = getReplacementForPlaceholder(placeholder)
            if (replacement == null) {
                success = false
                ""
            } else {
                replacement
            }
        }
        return if (success) updatedText else null
    }

    private fun DocumentDto.getReplacementForPlaceholder(placeholder: String): String? {
        val (parentFieldName, childPlaceholderName) = parsePlaceholder(placeholder)
        val dtoFieldMap = DtoFieldMap(this)
        return if (childPlaceholderName == null) {
            dtoFieldMap.getFieldValue(parentFieldName)
        } else {
            dtoFieldMap.getFieldValue(parentFieldName)
                .takeIf { it != DtoFieldMap.EMPTY_FIELD_VALUE }
                ?.let { dtoFieldMap.getFieldValue(childPlaceholderName) }
        }
    }

    private fun parsePlaceholder(placeholder: String): Pair<String, String?> {
        val placeholderParts = placeholder.split(">")
        val parentFieldName = placeholderParts.first()
        val childPlaceholderName = if (placeholderParts.size == 2) placeholderParts.last() else null
        return parentFieldName to childPlaceholderName
    }
}