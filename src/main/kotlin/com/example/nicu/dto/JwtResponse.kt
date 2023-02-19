package com.example.nicu.dto

class JwtResponse(
    var  token: String?,
    var  fullName: String?,
) {
    var  type: String = "Bearer"
}