package com.example.nicu.dto

class JwtResponse(
    var  token: String?,
    var  username: String?,
) {
    var  type: String = "Bearer"
}