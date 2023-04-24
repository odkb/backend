package com.example.nicu.controller.documents

import com.example.nicu.dto.documents.DocumentDto
import com.example.nicu.service.documents.DocumentHandler
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Interface for all document controllers.
 * /document replace to the name of the document.
 */
@RestController
@RequestMapping("/api/children/{childId}/documents")
abstract class DocumentController<T : DocumentDto>(
    private val documentHandler: DocumentHandler,
) {
    abstract val documentType: String

    val logger: KLogger
        get() = KotlinLogging.logger {}

    /**
     * Returns the [T] from the database.
     * The [childId] is the id of the child.
     */
    @GetMapping("/document")
    abstract fun getDocument(@PathVariable childId: String): ResponseEntity<T>

    /**
     * Saves the [documentDto] to the database.
     * The [childId] is the id of the child.
     */
    @PostMapping("/document")
    abstract fun saveDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<T>

    /**
     * Returns a byte array of the document.
     * The document is generated from the [documentDto].
     * The [childId] is the id of the child.
     */
    @PostMapping("/document/actions/print")
    fun printDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<ByteArray> {
        return try {
            val doc = documentHandler.getDocumentAsWord(documentType, documentDto)
            val documentBytes = doc.toByteArray()
            ResponseEntity
                .ok()
                .contentLength(documentBytes.size.toLong())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=${documentType}.docx")
                .body(documentBytes)
        } catch (e: Exception) {
            logger.error { e.message }
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while generating the document: ${e.message}".toByteArray())
        }
    }
}

/**
 * Enum class for the document types.
 * The title is used for the document name.
 */
sealed interface DocumentType {
    object PrimaryExamination : DocumentType {
        const val title = "primary-examination"
    }

    object DynamicObservationSheet : DocumentType {
        const val title = "dynamic-observation-sheet"
    }

    object SubstantiationDiagnosis : DocumentType {
        const val title = "substantiation-diagnosis"
    }
}