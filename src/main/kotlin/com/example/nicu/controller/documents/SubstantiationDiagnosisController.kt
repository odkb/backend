package com.example.nicu.controller.documents

import com.example.nicu.dto.docxDocumentsDto.SubstantiationDiagnosisDto
import com.example.nicu.service.docxDocuments.DocxDocumentService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/children/{childId}/documents")
class SubstantiationDiagnosisController(
    private val docxDocumentService: DocxDocumentService,
) : DocumentController<SubstantiationDiagnosisDto> {
    companion object {
        const val DOCUMENT_TYPE = "substantiation-diagnosis"
    }

    @GetMapping("/${DOCUMENT_TYPE}")
    override fun getDocument(@PathVariable childId: String): ResponseEntity<SubstantiationDiagnosisDto> {
        TODO("Not yet implemented")
    }

    @PostMapping("/${DOCUMENT_TYPE}")
    override fun printDocument(
        @RequestBody documentDto: SubstantiationDiagnosisDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        return try {
            val doc = docxDocumentService.getDocumentAsWord(DOCUMENT_TYPE, documentDto)
            val documentBytes = doc.toByteArray()
            return ResponseEntity
                .ok()
                .contentLength(documentBytes.size.toLong())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=${DOCUMENT_TYPE}.docx")
                .body(documentBytes)
        } catch (e: Exception) {
            logger.error { e.message }
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while generating the document: ${e.message}".toByteArray())
        }
    }

    @PostMapping("/${DOCUMENT_TYPE}/actions/print")
    override fun saveDocument(
        @RequestBody documentDto: SubstantiationDiagnosisDto,
        @PathVariable childId: String
    ): ResponseEntity<SubstantiationDiagnosisDto> {
        TODO("Not yet implemented")
    }
}