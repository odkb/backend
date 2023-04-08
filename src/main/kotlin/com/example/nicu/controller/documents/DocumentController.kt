package com.example.nicu.controller.documents

import com.example.nicu.dto.docxDocumentsDto.DocumentDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

sealed interface DocumentController<T : DocumentDto> {
    @GetMapping
    fun getDocument(@PathVariable childId: String): ResponseEntity<T>

    @PostMapping
    fun saveDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<T>

    @PostMapping
    fun printDocument(@RequestBody documentDto: T, @PathVariable childId: String): ResponseEntity<ByteArray>
}