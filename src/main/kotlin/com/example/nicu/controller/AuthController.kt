package com.example.nicu.controller

import com.example.nicu.config.security.jwt.JwtUtils
import com.example.nicu.dto.JwtResponse
import com.example.nicu.dto.LoginRequest
import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.service.db.EmployeeEntityService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtils: JwtUtils,
    private val employeeEntityService: EmployeeEntityService,
) {
    @PostMapping("/login")
    fun authUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<JwtResponse> {
        val authentication: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginRequest.username,
                loginRequest.password
            )
        )
        SecurityContextHolder.getContext().authentication = authentication
        val jwt: String = jwtUtils.generateJwtToken(authentication)
        val user: EmployeeEntity? = employeeEntityService.getEmployee(authentication.name)
        return if (user == null) {
            ResponseEntity.badRequest().build()
        } else {
            ResponseEntity.ok(
                JwtResponse(jwt, user.fullName)
            )
        }
    }
}