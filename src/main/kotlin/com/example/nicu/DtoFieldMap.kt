package com.example.nicu

import com.example.nicu.dto.docxDocumentsDto.DocumentDto
import com.example.nicu.utils.formatToddMMyyyy
import java.time.LocalDate
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

/*
Класс для получения значения поля по его имени
 */
class DtoFieldMap<T : DocumentDto>(dtoClass: KClass<T>) {
    private val fieldMap = HashMap<String, KProperty1<T, *>>()

    companion object {
        const val EMPTY_FIELD_VALUE = ""
    }

    init {
        dtoClass.memberProperties.forEach { fieldMap[it.name] = it }
    }

    fun getFieldValue(dto: T, fieldName: String): String {
        return when (val field = fieldMap[fieldName]?.get(dto)) {
            is List<*> -> field.joinToString(", ")
            null, "" -> EMPTY_FIELD_VALUE
            is LocalDate -> field.formatToddMMyyyy()
            else -> field.toString()
        }
    }
}