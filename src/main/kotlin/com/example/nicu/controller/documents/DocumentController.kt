package com.example.nicu.controller.documents

import com.example.nicu.dto.docxDocumentsDto.DocumentDto
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Interface for all document controllers.
 * /document replace to the name of the document.
 */
@RestController
@RequestMapping("/api/children/{childId}/documents")
internal interface DocumentController<T : DocumentDto> {
    val logger: KLogger
        get() = KotlinLogging.logger {}

    /**
     * Returns the [T] from the database.
     */
    @GetMapping("/document")
    fun getDocument(@PathVariable childId: String): ResponseEntity<T>

    /**
     * Saves the [documentDto] to the database.
     */
    @PostMapping("/document")
    fun saveDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<T>

    /**
     * Returns a byte array of the document.
     * The document is generated from the [documentDto].
     */
    @PostMapping("/document/actions/print")
    fun printDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<ByteArray>
}