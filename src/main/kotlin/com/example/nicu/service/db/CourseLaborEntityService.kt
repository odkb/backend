package com.example.nicu.service.db

import com.example.nicu.dto.documents.PrimaryExaminationDto
import com.example.nicu.entity.CourseLaborEntity
import com.example.nicu.repository.CourseLaborRepository
import org.springframework.stereotype.Service

@Service
class CourseLaborEntityService(
    private val repo: CourseLaborRepository,
) : EntityService<CourseLaborEntity> {

    override fun save(dto: PrimaryExaminationDto) {
        val courseLaborEntity = dtoToEntity(dto)
        repo.save(courseLaborEntity)
    }

    override fun dtoToEntity(dto: PrimaryExaminationDto): CourseLaborEntity {
        val courseLaborEntity = CourseLaborEntity()
        courseLaborEntity.gestationalAge = dto.gestationalAge
        courseLaborEntity.featuresCourseChildbirth = dto.featuresCourseChildbirth
        courseLaborEntity.presentation = dto.presentation
        courseLaborEntity.methodDelivery = dto.methodDelivery
        courseLaborEntity.methodDeliveryType = dto.methodDeliveryType
        courseLaborEntity.durationLabor = dto.durationLabor
        courseLaborEntity.strainingPeriod = dto.strainingPeriod
        courseLaborEntity.anhydrousPeriod = dto.anhydrousPeriod
        courseLaborEntity.waters = dto.waters?.joinToString()
        courseLaborEntity.watersVolume = dto.watersVolume
        courseLaborEntity.gender = dto.gender
        courseLaborEntity.birthWeight = dto.birthWeight
        courseLaborEntity.bodyLength = dto.length
        courseLaborEntity.headCircumference = dto.headCircumference
        courseLaborEntity.chestCircumference = dto.chestCircumference
        courseLaborEntity.apgarScore = dto.apgarScore
        courseLaborEntity.firstHelp = dto.firstHelp
        courseLaborEntity.firstHelpType = dto.firstHelpType?.joinToString()
        courseLaborEntity.anotherFirstHelp = dto.anotherFirstHelp
        courseLaborEntity.ventilation = dto.ventilation
        courseLaborEntity.ventilationType = dto.ventilationType?.joinToString()
        courseLaborEntity.ventilationTime = dto.ventilationTime
        courseLaborEntity.intubation = dto.intubation
        courseLaborEntity.intubationTime = dto.intubationTime
        courseLaborEntity.heartMassage = dto.heartMassage
        courseLaborEntity.heartMassageTime = dto.heartMassageTime
        courseLaborEntity.heartMassageInfo = dto.heartMassageInfo
        courseLaborEntity.adrenalin = dto.adrenalin
        courseLaborEntity.adrenalinTime = dto.adrenalinTime
        courseLaborEntity.adrenalinCount = dto.adrenalinCount
        courseLaborEntity.saline = dto.saline
        courseLaborEntity.salineTime = dto.salineTime
        courseLaborEntity.salineCount = dto.salineCount
        courseLaborEntity.amountAssistanceDeliveryRoom = dto.amountAssistanceDeliveryRoom
        return courseLaborEntity
    }
}