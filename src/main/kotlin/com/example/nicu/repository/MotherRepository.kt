package com.example.nicu.repository

import com.example.nicu.entity.MotherEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MotherRepository : CrudRepository<MotherEntity, Long> {
}