package com.example.nicu.dto.documents

import com.example.nicu.DtoFieldMap
import kotlinx.serialization.Transient

@Deprecated("Class will be removed in future. Change to Utils class")
sealed class DocumentDto {
    @Transient
    val dtoFieldMap by lazy(LazyThreadSafetyMode.NONE) { DtoFieldMap(this) }

    fun getFieldValue(fieldName: String): String = dtoFieldMap.getFieldValue(fieldName)
}