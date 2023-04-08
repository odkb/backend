package com.example.nicu.controller.documents

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.service.docxDocuments.DocxDocumentService
import org.springframework.http.HttpHeaders
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
        const val FILE_RESOURCE = "templates/${DOCUMENT_TYPE}.docx"
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

    @PostMapping("/$DOCUMENT_TYPE/print")
    override fun printDocument(
        @RequestBody documentDto: PrimaryExaminationDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        val inputStream = javaClass.classLoader.getResourceAsStream(FILE_RESOURCE)
        val doc = docxDocumentService.getDocumentAsWord(inputStream, documentDto)
        val documentBytes = doc.toByteArray()
        return ResponseEntity
            .ok()
            .contentLength(documentBytes.size.toLong())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$DOCUMENT_TYPE.docx")
            .body(documentBytes)
    }
}