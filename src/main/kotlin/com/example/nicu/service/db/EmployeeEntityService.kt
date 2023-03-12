package com.example.nicu.service.db

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EmployeeEntityService(
    private val employeeRepository: EmployeeRepository,
) {
    @Transactional
    fun getEmployee(id: Long): Optional<EmployeeEntity> = employeeRepository.findById(id)

    @Transactional
    fun getEmployee(username: String): Optional<EmployeeEntity> = employeeRepository.findByUsername(username)
}