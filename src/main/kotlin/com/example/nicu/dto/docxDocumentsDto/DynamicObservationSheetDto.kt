package com.example.nicu.dto.docxDocumentsDto

import com.example.nicu.DtoFieldMap
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class DynamicObservationSheetDto(
    val a: String? = null,
) : DocumentDto {
    @Transient
    private val dtoFieldMap = DtoFieldMap(DynamicObservationSheetDto::class)

    override fun getFieldValue(fieldName: String): String = dtoFieldMap.getFieldValue(this, fieldName)
}