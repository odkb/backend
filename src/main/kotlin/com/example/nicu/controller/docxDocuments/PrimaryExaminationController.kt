package com.example.nicu.controller.docxDocuments

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.service.docxDocuments.PrimaryExaminationService
import mu.KotlinLogging
import org.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*


private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/docxDocuments/primaryExamination")
class PrimaryExaminationController {

    @PostMapping("/fillDocument")
    fun getData(@RequestBody data: PrimaryExaminationDto) : ResponseEntity<*>?{
        val dataJson = JSONObject(data)
        val primaryExamination = PrimaryExaminationService()
        val doc = primaryExamination.fillDocument("src/main/resources/templates/primary_examination_OPN.docx", dataJson)
        val out = ByteArrayOutputStream()
        doc.write(out)
        out.close()
        doc.close()
        val documentBytes = out.toByteArray()
        logger.info{documentBytes}
        return ResponseEntity
            .ok()
            .body(documentBytes)
    }
}