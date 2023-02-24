package com.example.nicu.controller.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/docxDocuments/primaryExamination")
class PrimaryExaminationController {

    @GetMapping("/getData")
    fun getData(@RequestBody body: PrimaryExaminationDto){
        if(body != null){
            val json = body
            println(json)
        }
    }
}