package com.example.nicu.controller.documents

import com.example.nicu.controller.documents.SubstantiationDiagnosisController.Companion.DOCUMENT_TYPE
import com.example.nicu.dto.documents.SubstantiationDiagnosisDto
import com.example.nicu.service.documents.DocumentHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/children/{childId}/documents/${DOCUMENT_TYPE}")
class SubstantiationDiagnosisController(
    documentHandler: DocumentHandler,
) : DocumentController<SubstantiationDiagnosisDto>(documentHandler) {
    companion object {
        const val DOCUMENT_TYPE = DocumentType.SubstantiationDiagnosis.title
    }

    override val documentType: String
        get() = DOCUMENT_TYPE

    @GetMapping
    override fun getDocument(
        @PathVariable childId: String
    ): ResponseEntity<SubstantiationDiagnosisDto> {
        TODO("Not yet implemented")
    }

    @PostMapping
    override fun saveDocument(
        @RequestBody documentDto: SubstantiationDiagnosisDto,
        @PathVariable childId: String
    ): ResponseEntity<SubstantiationDiagnosisDto> {
        TODO("Not yet implemented")
    }

    @PostMapping(PRINT_ENDPOINT)
    override fun printDocument(
        @RequestBody documentDto: SubstantiationDiagnosisDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        return super.printDocument(documentDto, childId)
    }
}