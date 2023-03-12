package com.example.nicu

import com.example.nicu.dto.docxDocumentsDto.DocsDto
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

/*
Класс для получения значения поля по его имени
 */
class DtoFieldMap<T : DocsDto>(dtoClass: KClass<T>) {
    private val fieldMap = HashMap<String, KProperty1<T, *>>()

    init {
        dtoClass.memberProperties.forEach { fieldMap[it.name] = it }
    }

    fun getFieldValue(dto: T, fieldName: String): String {
        return when (val field = fieldMap[fieldName]?.get(dto)) {
            is List<*> -> field.joinToString(", ")
            null -> "Не выбрано"
            else -> field.toString()
        }
    }
}