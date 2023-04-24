package com.example.nicu.dto.documents

import kotlinx.serialization.Serializable

@Serializable
data class SubstantiationDiagnosisDto(
    val a: String? = ""
) : DocumentDto() {
    
}