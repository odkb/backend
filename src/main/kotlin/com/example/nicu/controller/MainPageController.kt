package com.example.nicu.controller

import com.example.nicu.dto.ChildDataFromNewBornTableDto
import com.example.nicu.repository.ChildRepository
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
    fun read() : List<ChildDataFromNewBornTableDto>{
        val childrenData = mutableListOf<ChildDataFromNewBornTableDto>()
        for (child in childRepository.findAll()){

            childrenData.add(ChildDataFromNewBornTableDto(
                child.fullName,
                child.birthDateTime,
                child.id,
            ))
        }

        return childrenData
    }
}