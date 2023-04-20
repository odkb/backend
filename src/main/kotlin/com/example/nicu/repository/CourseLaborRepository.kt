package com.example.nicu.repository

import com.example.nicu.entity.CourseLaborEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseLaborRepository : CrudRepository<CourseLaborEntity, Long> {
}