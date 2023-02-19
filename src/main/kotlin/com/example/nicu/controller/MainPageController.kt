package com.example.nicu.controller

import com.example.nicu.dto.ChildDataFromNewBornTable
import com.example.nicu.entity.ChildEntity
import com.example.nicu.entity.EmployeeEntity
import com.example.nicu.repository.ChildRepository
import com.example.nicu.repository.EmployeeRepository
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/data")
class MainPageController(
    private val childRepository : ChildRepository
) {

    @GetMapping("/getChildrensDataFromNewbornTable")
    fun read() : List<ChildDataFromNewBornTable>{
        val childrenData = mutableListOf<ChildDataFromNewBornTable>()
        for (child in childRepository.findAll()){

            childrenData.add(ChildDataFromNewBornTable(
                child.fullName,
                child.birthDateTime,
                child.id,
            ))
        }

        return childrenData
    }
}