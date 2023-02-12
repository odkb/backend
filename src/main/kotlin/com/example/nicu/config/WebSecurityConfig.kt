package com.example.nicu.config

import com.example.nicu.security.JWT.AuthEntryPointJwt
import com.example.nicu.security.JWT.AuthTokenFilter
import com.example.nicu.security.JWT.JwtUtils
import com.example.nicu.security.PBKDF2PasswordEncoder
import com.example.nicu.service.EmployeeDetailsServiceImpl
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*


private val logger = KotlinLogging.logger {}

@Configuration
@EnableWebSecurity
@ComponentScan("com.example")
class WebSecurityConfig(
    private val jwtUtils: JwtUtils,
    private val employeeDetailsService: EmployeeDetailsServiceImpl,
    private val unauthorizedHandler : AuthEntryPointJwt,
){

    @Value("\${app.jwtSecret}")
    private val secretCode : CharSequence = ""
    @Bean
    fun authenticationJwtTokenFilter(): AuthTokenFilter? = AuthTokenFilter(jwtUtils, employeeDetailsService)


    @Bean
    @Throws(Exception::class)
    fun configure(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .requestMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()

        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
        return httpSecurity.build();
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager?
            = authenticationConfiguration.authenticationManager

    @Bean
    fun passwordEncoder(): PasswordEncoder? = PBKDF2PasswordEncoder()


}