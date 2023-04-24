package com.example.nicu.dto.child


import com.example.nicu.entity.ChildEntity
import java.time.LocalDateTime

data class ChildInfoDto(
    val childId: Long,
    val fullName: String?,
    val birthday: LocalDateTime?,
)

fun ChildEntity.toChildInfoDto(): ChildInfoDto {
    return ChildInfoDto(
        childId = id!!,
        fullName = fullName,
        //Временный элвис
        birthday = birthday ?: LocalDateTime.now()
    )
}