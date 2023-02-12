package com.example.nicu.security.JWT

import com.example.nicu.service.EmployeeDetailsImpl
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}
@Component
class JwtUtils {
    @Value("\${app.jwtSecret}")
    val jwtSecret: String? = null

    @Value("\${app.jwtExpirationMs}")
    val jwtExpirationMs: Int = 0

    fun generateJwtToken(authentication: Authentication): String? {
        val userPrincipal: EmployeeDetailsImpl = authentication.principal as EmployeeDetailsImpl
        logger.info("Generating JWT token")
        return Jwts.builder().setSubject(userPrincipal.username).setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret).compact()
    }

    fun validateJwtToken(jwt: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt)
            return true
        } catch (e: MalformedJwtException) {
            System.err.println(e.message)
        } catch (e: IllegalArgumentException) {
            System.err.println(e.message)
        }
        return false
    }

    fun getUserNameFromJwtToken(jwt: String?): String {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).body.subject
    }

}