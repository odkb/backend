package com.example.nicu.controller.documents

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.service.docxDocuments.DocxDocumentService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*

@RestController
@RequestMapping("/api/children/{childId}/documents")
class PrimaryExaminationDocumentController(
    private val docxDocumentService: DocxDocumentService,
) : DocumentController<PrimaryExaminationDto> {
    companion object {
        const val DOCUMENT_TYPE = "primary-examination"
    }

    @GetMapping("/$DOCUMENT_TYPE")
    override fun getDocument(
        @PathVariable childId: String
    ): ResponseEntity<PrimaryExaminationDto> {
        TODO("Not yet implemented")
    }

    @PostMapping("/$DOCUMENT_TYPE")
    override fun saveDocument(
        @RequestBody documentDto: PrimaryExaminationDto,
        @PathVariable childId: String
    ): ResponseEntity<PrimaryExaminationDto> {
        TODO("Not yet implemented")
    }

    @PostMapping("/$DOCUMENT_TYPE/actions/print")
    override fun printDocument(
        @RequestBody documentDto: PrimaryExaminationDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        return try {
            val doc = docxDocumentService.getDocumentAsWord(DOCUMENT_TYPE, documentDto)
            val documentBytes = doc.toByteArray()
            return ResponseEntity
                .ok()
                .contentLength(documentBytes.size.toLong())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$DOCUMENT_TYPE.docx")
                .body(documentBytes)
        } catch (e: Exception) {
            logger.error { e.message }
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while generating the document: ${e.message}".toByteArray())
        }
    }
}