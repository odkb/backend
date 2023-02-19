package com.example.nicu.repository

import com.example.nicu.entity.ChildEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChildRepository : JpaRepository<ChildEntity, Long> {
    override fun findAll(): List<ChildEntity>

//    fun getFullName(): String
//    fun getDateOfBirth(): String
//    fun getId(): String
}