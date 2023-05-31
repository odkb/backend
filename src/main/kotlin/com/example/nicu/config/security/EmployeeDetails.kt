package com.example.nicu.config.security

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class EmployeeDetails(
    private val employeeRepository: EmployeeRepository
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: EmployeeEntity = employeeRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User Not Found with username: $username")

        return User
            .withUsername(user.username)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .password(user.password)
            .roles("USER")
            .build()
    }
}