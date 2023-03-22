package com.example.nicu.service.db

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeEntityService(
    private val employeeRepository: EmployeeRepository,
) {
    fun getEmployee(id: Long): Optional<EmployeeEntity> = employeeRepository.findById(id)

    fun getEmployee(username: String): Optional<EmployeeEntity> = employeeRepository.findByUsername(username)
}