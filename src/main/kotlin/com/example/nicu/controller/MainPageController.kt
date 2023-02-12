package com.example.nicu.controller

import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.EmployeeRepository
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

private val logger = KotlinLogging.logger {}

@RestController
class MainPageController(
    private val employeeRepository : EmployeeRepository
) {

    @GetMapping("/clients")
    fun read() : EmployeeEntity{
        return employeeRepository.findByUsername("lev").get()

    }
}