package com.example.nicu.service.db

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeEntityService(
    private val employeeRepository: EmployeeRepository,
) {
    fun getEmployee(id: Long): EmployeeEntity? = employeeRepository.findEmployeeEntityById(id)

    fun getEmployee(username: String): EmployeeEntity? = employeeRepository.findByUsername(username)
}