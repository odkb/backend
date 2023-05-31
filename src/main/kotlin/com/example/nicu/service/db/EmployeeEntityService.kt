package com.example.nicu.service.db

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeEntityService(
    private val employeeRepository: EmployeeRepository,
) {
    /**
     * Returns the employee with the given [id].
     */
    fun getEmployee(id: Long): EmployeeEntity? = employeeRepository.findEmployeeEntityById(id)

    /**
     * Returns the employee with the given [username].
     */
    fun getEmployee(username: String): EmployeeEntity? = employeeRepository.findByUsername(username)
}