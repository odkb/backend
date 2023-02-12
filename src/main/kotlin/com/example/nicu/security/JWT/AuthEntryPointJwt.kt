package com.example.nicu.security.JWT

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component
import java.io.IOException


@Component
class AuthEntryPointJwt : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest, response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        System.err.println(authException.message)
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        val body: MutableMap<String, Any?> = HashMap()
        body["status"] = HttpServletResponse.SC_UNAUTHORIZED
        body["error"] = "Unauthorized"
        body["message"] = authException.message
        body["path"] = request.servletPath
        val mapper = ObjectMapper()
        mapper.writeValue(response.outputStream, body)
    }
}