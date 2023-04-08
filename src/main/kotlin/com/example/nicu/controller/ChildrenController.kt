package com.example.nicu.controller

import com.example.nicu.dto.child.ChildIdDto
import com.example.nicu.dto.child.ChildInfoDto
import com.example.nicu.service.db.ChildEntityService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/api/children")
class ChildrenController(
    private val childEntityService: ChildEntityService,
) {
    @GetMapping("/")
    fun getChildren(
        @PathVariable childId: Long,
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "10") size: Int
    ): ResponseEntity<Page<ChildInfoDto>> {
        val children = childEntityService.getChildrenPage(page, size)
        return ResponseEntity.ok(children)
    }

    @PostMapping("/import")
    fun importChild(@RequestBody childRequest: ChildIdDto) {
        //реализовать после получения API.
        childEntityService.importChildFromOdkbAPI()
    }
}