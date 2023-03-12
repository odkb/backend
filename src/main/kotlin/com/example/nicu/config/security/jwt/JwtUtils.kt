package com.example.nicu.config.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
class JwtUtils {
    @Value("\${app.jwtSecret}")
    private lateinit var jwtSecret: String

    @Value("\${app.jwtExpirationMs}")
    private lateinit var jwtExpirationMs: String

    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal: User = authentication.principal as User
        logger.debug { "Generating JWT token" }
        val expirationTimeMillis = Date().time + jwtExpirationMs.toLong()
        val expirationDate = Date(expirationTimeMillis)
        return Jwts.builder()
            .setSubject(userPrincipal.username)
            .setIssuedAt(Date())
            .setExpiration(expirationDate)
            .signWith(Keys.hmacShaKeyFor(jwtSecret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }

    fun validateJwtToken(jwt: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret.toByteArray()).build()
                .parseClaimsJws(jwt)
            return true
        } catch (e: MalformedJwtException) {
            System.err.println(e.message)
        } catch (e: IllegalArgumentException) {
            System.err.println(e.message)
        }
        return false
    }

    fun getUserNameFromJwtToken(jwt: String): String {
        return Jwts.parserBuilder().setSigningKey(jwtSecret.toByteArray())
            .build().parseClaimsJws(jwt).body.subject
    }
}