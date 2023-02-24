package com.example.nicu.controller.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/docxDocuments/primaryExamination")
class PrimaryExaminationController {

    @PostMapping("/getData")
    fun getData(@RequestBody body: fff){
        if(body != null){
            val json = body
            println(json)
        }
    }

}

data class fff(
    val fullNameChild: String,
    val EPIDNumber: String,
)