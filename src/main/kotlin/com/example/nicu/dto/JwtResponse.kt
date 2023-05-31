package com.example.nicu.dto

import kotlinx.serialization.Serializable

@Serializable
data class JwtResponse(
    val token: String,
    val fullName: String,
) {
    private val type: String = "Bearer"
}