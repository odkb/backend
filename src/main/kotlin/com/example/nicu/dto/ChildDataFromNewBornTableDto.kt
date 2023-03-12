package com.example.nicu.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChildDataFromNewBornTableDto(
    val fullName: String,
    val dateOfBirth: String,
    val id: String,
)