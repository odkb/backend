package com.example.nicu

import com.example.nicu.dto.documents.DocumentDto
import com.example.nicu.utils.formatToddMMyyyy
import com.example.nicu.utils.formatToddMMyyyyHHmm
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

/**
 * This class is used to map the fields of a [DocumentDto] to their values.
 */
class DtoFieldMap<T : DocumentDto>(val dto: T) {
    private val fieldMap = HashMap<String, Any?>()

    companion object {
        const val EMPTY_FIELD_VALUE = ""
    }

    init {
        @Suppress("UNCHECKED_CAST")
        val dtoClass = dto::class as KClass<T>
        dtoClass.memberProperties.forEach { fieldMap[it.name] = it.get(dto) }
    }

    fun getFieldValue(fieldName: String): String {
        return when (val field = fieldMap[fieldName]) {
            is List<*> -> field.joinToString(", ")
            null, "" -> EMPTY_FIELD_VALUE
            is LocalDate -> field.formatToddMMyyyy()
            is LocalDateTime -> field.formatToddMMyyyyHHmm()
            else -> field.toString()
        }
    }
}