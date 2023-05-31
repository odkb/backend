package com.example.nicu.service.db

import com.example.nicu.dto.documents.PrimaryExaminationDto

sealed interface EntityService<out T> {
    fun save(dto: PrimaryExaminationDto)

    fun dtoToEntity(dto: PrimaryExaminationDto): T
}