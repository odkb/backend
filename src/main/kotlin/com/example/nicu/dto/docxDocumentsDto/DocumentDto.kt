package com.example.nicu.dto.docxDocumentsDto

import com.example.nicu.DtoFieldMap

sealed interface DocumentDto {
    val dtoFieldMap: DtoFieldMap<out DocumentDto>

    fun getFieldValue(fieldName: String): String
}