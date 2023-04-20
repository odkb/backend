package com.example.nicu.service.db

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.entity.PregnancyCourseEntity
import com.example.nicu.repository.PregnancyCourseRepository
import org.springframework.stereotype.Service

@Service
class PregnancyCourseEntityService(
    private val repo: PregnancyCourseRepository
) : EntityService<PregnancyCourseEntity> {
    override fun save(dto: PrimaryExaminationDto) {
        val pregnancyCourseEntity = dtoToEntity(dto)
        repo.save(pregnancyCourseEntity)
    }

    override fun dtoToEntity(dto: PrimaryExaminationDto): PregnancyCourseEntity {
        val pregnancyCourseEntity = PregnancyCourseEntity()
        pregnancyCourseEntity.pregnancy = dto.pregnancy
        pregnancyCourseEntity.childBirth = dto.birthday
        pregnancyCourseEntity.previousPregnancies = dto.previousPregnancies
        pregnancyCourseEntity.dataSiblings = dto.dataSiblings
        pregnancyCourseEntity.featuresCoursePregnancy = dto.featuresCoursePregnancy
        pregnancyCourseEntity.previousPregnanciesExtra = dto.previousPregnanciesExtra
        pregnancyCourseEntity.steroidProphylaxis = dto.steroidProphylaxis
        pregnancyCourseEntity.steroidProphylaxisExtra = dto.steroidProphylaxisExtra
        return pregnancyCourseEntity
    }
}