package com.example.nicu.repository

import com.example.nicu.entity.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Long> {
    fun findEmployeeEntityById(id: Long): EmployeeEntity?

    fun findByUsername(username: String): EmployeeEntity?
}