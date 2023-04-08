package com.example.nicu.repository

import com.example.nicu.entity.ChildEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ChildRepository : PagingAndSortingRepository<ChildEntity, Long> {
}