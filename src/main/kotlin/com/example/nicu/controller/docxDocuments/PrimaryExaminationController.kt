package com.example.nicu.controller.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.service.docxDocuments.PrimaryExaminationService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*

@RestController
@RequestMapping("/api/docxDocuments/primaryExamination")
class PrimaryExaminationController(
    private val primaryExaminationService: PrimaryExaminationService,
) {
    companion object {
        const val FILE_ADDRESS = "src/main/resources/templates/primary_examination_OPN.docx"
    }

    @PostMapping("/fillDocument")
    fun getData(@RequestBody examinationDto: PrimaryExaminationDto): ResponseEntity<ByteArray> {
        val doc = primaryExaminationService.fillDocument(FILE_ADDRESS, examinationDto)
        val documentBytes = doc.toByteArray()
        return ResponseEntity
            .ok()
            .contentLength(documentBytes.size.toLong())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.docx")
            .body(documentBytes)
    }
}