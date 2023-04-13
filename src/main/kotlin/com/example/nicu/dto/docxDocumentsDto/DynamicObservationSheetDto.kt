package com.example.nicu.dto.docxDocumentsDto

import kotlinx.serialization.Serializable

@Serializable
data class DynamicObservationSheetDto(
    val a: String? = null,
) : DocumentDto() {

}