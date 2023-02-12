package com.example.nicu.repository

import com.example.nicu.entity.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Long> {
    fun findByUsername(username: String): Optional<EmployeeEntity>
}