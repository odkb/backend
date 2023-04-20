package com.example.nicu.repository

import com.example.nicu.entity.MotherEntity
import com.example.nicu.entity.PregnancyCourseEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PregnancyCourseRepository : CrudRepository<PregnancyCourseEntity, Long> {
}