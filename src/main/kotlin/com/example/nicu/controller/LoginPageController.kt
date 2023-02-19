package com.example.nicu.controller

import com.example.nicu.dto.JwtResponse
import com.example.nicu.security.JWT.JwtUtils
import com.example.nicu.dto.LoginRequest
import com.example.nicu.service.EmployeeDetailsImpl
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.Authentication;

private val logger = KotlinLogging.logger {}
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:3000/login")
//@CrossOrigin(origins = ["http://localhost:3000"])
class LoginPageController(
    var authenticationManager: AuthenticationManager,
    var jwtUtils: JwtUtils
) {

    @PostMapping("/login")
    fun authUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<*>? {
        logger.info(loginRequest.username)
        logger.info(loginRequest.password)
        val authentication: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginRequest.username,
                loginRequest.password
            )
        )
        SecurityContextHolder.getContext().authentication = authentication
        val jwt: String? = jwtUtils.generateJwtToken(authentication)
        logger.info { "jwt создан" }
        val userDetails: EmployeeDetailsImpl = authentication.principal as EmployeeDetailsImpl
        return ResponseEntity.ok<Any>(
            JwtResponse(
                jwt,
                userDetails.getFullName(),
            )
        )
    }

}