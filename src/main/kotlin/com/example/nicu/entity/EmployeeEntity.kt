package com.example.nicu.entity

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name = "employees")
class EmployeeEntity(
    @Id
    @Column(name = "employee_id", nullable = false)
    var id: Long? = null,

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var password: String,

    @Column(name = "first_name", nullable = false)
    var firstName: String,

    @Column(name = "last_name", nullable = false)
    var lastName: String,

    @Column(name = "second_name", nullable = true)
    var middleName: String? = null,
) {
    @get:Transient
    val fullName: String
        get() = "$lastName ${firstName[0]}.${middleName?.let { " ${it[0]}." } ?: ""}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as EmployeeEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}