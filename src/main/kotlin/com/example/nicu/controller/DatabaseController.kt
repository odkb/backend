package com.example.nicu.controller

import com.example.nicu.dto.documents.PrimaryExaminationDto
import com.example.nicu.service.db.ChildEntityService
import com.example.nicu.service.db.CourseLaborEntityService
import com.example.nicu.service.db.MotherEntityService
import com.example.nicu.service.db.PregnancyCourseEntityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/children/")
class DatabaseController(
    private val motherEntityService: MotherEntityService,
    private val pregnancyCourseEntityService: PregnancyCourseEntityService,
    private val courseLaborEntityService: CourseLaborEntityService,
    private val childEntityService: ChildEntityService
    ) {

    //Пока очень тестовая версия контроллера
    @PostMapping("/saveData")
    fun saveData(
        @RequestBody documentDto: PrimaryExaminationDto,
    ) {
        motherEntityService.save(documentDto)
        pregnancyCourseEntityService.save(documentDto)
        courseLaborEntityService.save(documentDto)
        childEntityService.save(documentDto)
    }
}