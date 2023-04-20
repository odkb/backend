package com.example.nicu.dto

import com.example.nicu.utils.LocalDateSerializer
import jakarta.persistence.Column
import jakarta.persistence.Id
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class MotherDto(
    var id: Long? = null,
    var fullName: String,
    var omsIssued: String,
    var omsNumber: String,
    var snils: String,
    var homeAddressRegistration: String,
    var residenceAddress: String,
    var passport: String,
    var phoneMother: String,
    var phoneFather: String,
    var maternalInfectiousHistory: String,
    var maternalIllnesses: String,
    var bloodGroup: String,
    @Serializable(LocalDateSerializer::class)
    var birthDate: LocalDate?,
    var hivStatusFather: String,
    var hivStatusMother: String,
    var withChild: String,
)
