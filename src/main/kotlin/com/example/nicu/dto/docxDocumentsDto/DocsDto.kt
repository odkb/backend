package com.example.nicu.dto.docxDocumentsDto

sealed interface DocsDto {
    fun getFieldValue(fieldName: String): String
}