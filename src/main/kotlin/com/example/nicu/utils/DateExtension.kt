package com.example.nicu.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.formatToddMMyyyy(): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return this.format(formatter)
}