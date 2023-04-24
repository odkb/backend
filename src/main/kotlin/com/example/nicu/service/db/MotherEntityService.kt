package com.example.nicu.service.db

import com.example.nicu.dto.documents.PrimaryExaminationDto
import com.example.nicu.entity.MotherEntity
import com.example.nicu.repository.MotherRepository
import org.springframework.stereotype.Service

@Service
class MotherEntityService(
    private val repo: MotherRepository,
) : EntityService<MotherEntity> {
    override fun save(dto: PrimaryExaminationDto) {
        val motherEntity = dtoToEntity(dto)
        repo.save(motherEntity)
    }

    override fun dtoToEntity(dto: PrimaryExaminationDto): MotherEntity {
        val motherEntity = MotherEntity()
        motherEntity.motherFullName = dto.motherFullName
        motherEntity.motherRegistration = dto.motherRegistration
        motherEntity.motherAccommodation = dto.motherAccommodation
        motherEntity.motherOms = dto.motherOMS
        motherEntity.motherOmsNumber = dto.motherOMSNumber
        motherEntity.motherSnils = dto.motherSNILS
        motherEntity.motherPassport = dto.motherPassport
        motherEntity.motherPhoneNumber = dto.motherPhoneNumber
        motherEntity.fatherPhoneNumber = dto.fatherPhoneNumber
        motherEntity.motherWithChild = dto.motherWithChild
        motherEntity.motherDateBirth = dto.motherDateBirth
        motherEntity.familyStatus = dto.familyStatus
        motherEntity.maternalIllnesses = dto.maternalIllnesses
        motherEntity.motherBloodGroup = dto.motherBloodGroup
        motherEntity.erythrocyteBody = dto.erythrocyteBody
        motherEntity.hivTestingMother = dto.HIVTestingMother
        motherEntity.hivTestingFather = dto.HIVTestingFather
        motherEntity.maternalInfectiousHistory = dto.maternalInfectiousHistory
        return motherEntity
    }
}
