package com.example.nicu.service.db

import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import jakarta.persistence.Entity
import javax.xml.crypto.Data

sealed interface EntityService<out T> {
    fun save(dto: PrimaryExaminationDto)

    fun dtoToEntity(dto: PrimaryExaminationDto): T
}