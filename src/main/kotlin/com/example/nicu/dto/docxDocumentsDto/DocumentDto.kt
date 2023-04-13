package com.example.nicu.dto.docxDocumentsDto

import com.example.nicu.DtoFieldMap
import kotlinx.serialization.Transient

sealed class DocumentDto {
    @Transient
    val dtoFieldMap by lazy(LazyThreadSafetyMode.NONE) { DtoFieldMap(this) }

    fun getFieldValue(fieldName: String): String = dtoFieldMap.getFieldValue(fieldName)
}