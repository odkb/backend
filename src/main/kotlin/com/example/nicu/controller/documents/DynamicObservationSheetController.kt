package com.example.nicu.controller.documents

import com.example.nicu.controller.documents.DynamicObservationSheetController.Companion.DOCUMENT_TYPE
import com.example.nicu.dto.documents.DynamicObservationSheetDto
import com.example.nicu.service.documents.DocumentHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/children/{childId}/documents/${DOCUMENT_TYPE}")
class DynamicObservationSheetController(
    documentHandler: DocumentHandler,
) : DocumentController<DynamicObservationSheetDto>(documentHandler) {
    companion object {
        const val DOCUMENT_TYPE = DocumentType.DynamicObservationSheet.title
    }

    override val documentType: String
        get() = DOCUMENT_TYPE

    @GetMapping
    override fun getDocument(
        @PathVariable childId: String
    ): ResponseEntity<DynamicObservationSheetDto> {
        TODO("Not yet implemented")
    }

    @PostMapping
    override fun saveDocument(
        @RequestBody documentDto: DynamicObservationSheetDto,
        @PathVariable childId: String
    ): ResponseEntity<DynamicObservationSheetDto> {
        TODO("Not yet implemented")
    }

    @PostMapping(PRINT_ENDPOINT)
    override fun printDocument(
        @RequestBody documentDto: DynamicObservationSheetDto,
        @PathVariable childId: String
    ): ResponseEntity<ByteArray> {
        return super.printDocument(documentDto, childId)
    }
}
