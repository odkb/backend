package com.example.nicu.controller.documents

import com.example.nicu.controller.documents.PrimaryExaminationDocumentController.Companion.DOCUMENT_TYPE
import com.example.nicu.dto.documents.PrimaryExaminationDto
import com.example.nicu.service.documents.DocumentHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*

@RestController
@RequestMapping("/api/children/{childId}/documents/${DOCUMENT_TYPE}")
class PrimaryExaminationDocumentController(
    documentHandler: DocumentHandler,
) : DocumentController<PrimaryExaminationDto>(documentHandler) {
    companion object {
        const val DOCUMENT_TYPE = DocumentType.PrimaryExamination.title
    }

    override val documentType: String
        get() = DOCUMENT_TYPE


    @GetMapping
    override fun getDocument(
        @PathVariable childId: String
    ): ResponseEntity<PrimaryExaminationDto> {
        TODO("Not yet implemented")
    }

    @PostMapping
    override fun saveDocument(
        @RequestBody documentDto: PrimaryExaminationDto,
        @PathVariable childId: String
    ): ResponseEntity<PrimaryExaminationDto> {
        TODO("Not yet implemented")
    }

    @PostMapping(PRINT_ENDPOINT)
    override fun printDocument(
        @RequestBody documentDto: PrimaryExaminationDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        return super.printDocument(documentDto, childId)
    }
}