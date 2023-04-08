package com.example.nicu.service.db

import com.example.nicu.dto.child.ChildInfoDto
import com.example.nicu.dto.child.toChildInfoDto
import com.example.nicu.repository.ChildRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ChildEntityService(
    private val repo: ChildRepository,
) {
    fun getChildrenPage(page: Int, size: Int): Page<ChildInfoDto> {
        val pageable: Pageable = PageRequest.of(page, size)
        val userPage = repo.findAll(pageable)
        return userPage.map { user -> user.toChildInfoDto() }
    }

    fun importChildFromOdkbAPI(): Unit {
        // TODO: Реализовать создание шкилатрона
    }
}