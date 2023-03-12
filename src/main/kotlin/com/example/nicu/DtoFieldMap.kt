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
        dtoClass.memberProperties
            //.filter { it.returnType.isSubtypeOf(Any::class.starProjectedType) } Удалить мб смотря какие будут поля
            .forEach { fieldMap[it.name] = it }
    }

    fun getFieldValue(dto: T, fieldName: String): String =
        fieldMap[fieldName]?.get(dto)?.toString() ?: "Не задано"
}