package com.example.nicu.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalDate::class)
object LocalDateSerializer : KSerializer<LocalDate?> {
    private val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    override fun serialize(encoder: Encoder, value: LocalDate?) {
        if (value == null) {
            encoder.encodeNull()
        } else {
            encoder.encodeString(value.format(outputFormatter))
        }
    }

    override fun deserialize(decoder: Decoder): LocalDate? {
        val dateString = decoder.decodeString()
        return if (dateString.isEmpty()) {
            null
        } else {
            LocalDate.parse(dateString, inputFormatter)
        }
    }
}