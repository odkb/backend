package com.example.nicu.dto.child

import com.example.nicu.entity.ChildEntity
import java.time.LocalDate

data class ChildInfoDto(
    val childId: Long,
    val fullName: String,
    val birthday: LocalDate,
)

fun ChildEntity.toChildInfoDto(): ChildInfoDto {
    return ChildInfoDto(
        childId = id!!,
        fullName = fullName,
        //Временный элвис
        birthday = childbirth ?: LocalDate.now()
    )
}