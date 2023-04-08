package com.example.nicu.dto.docxDocumentsDto

sealed interface DocumentDto {
    fun getFieldValue(fieldName: String): String
}