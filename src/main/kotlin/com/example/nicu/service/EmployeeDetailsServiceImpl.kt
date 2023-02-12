package com.example.nicu.service

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class EmployeeDetailsServiceImpl(
    var employeeRepository: EmployeeRepository
) : UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val user: EmployeeEntity = employeeRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User Not Found with username: $username") }
        return EmployeeDetailsImpl.build(user)
    }
}