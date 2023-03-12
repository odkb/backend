package com.example.nicu.service.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.DocsDto
import org.apache.commons.io.IOUtils
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

@Service
class PrimaryExaminationService {
    fun fillDocument(path: String, dto: DocsDto): XWPFDocument {
        val file = File(path)
        val inputStream = FileInputStream(file)
        val outputFile = File(file.parent, "copy_" + file.name)
        val outputStream = FileOutputStream(outputFile)
        IOUtils.copy(inputStream, outputStream)
        outputStream.close()
        val copyDoc = XWPFDocument(OPCPackage.open(FileInputStream(outputFile)))
        for (paragraph in copyDoc.paragraphs) {
            val runs = paragraph.runs
            var replaceable = false
            for (run in runs) {
                val text = run.text()
                if (text.startsWith("$$")) {
                    replaceable = true
                    run.setText("", 0)
                } else if (replaceable) {
                    val updatedText = dto.getFieldValue(text)
                    replaceable = false
                    run.setText(updatedText, 0)
                }
            }
        }
        return copyDoc
    }
}