package com.example.nicu.entity

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name = "employees")
class EmployeeEntity(
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "username")
    var username: String,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "second_name")
    var secondName: String? = null,

    @Column(name = "params")
    var params: String? = null,

    @Column(name = "roles_id")
    var rolesId: String? = null,

    @Column(name = "reanimation_id")
    var reanimationId: String? = null,

    @Column(name = "specialisation")
    var specialisation: String? = null,

    @Column(name = "is_admin")
    var isAdmin: Boolean,
) {
    fun getFullName() = "$lastName ${firstName?.get(0) ?: ""}. ${secondName?.get(0) ?: ""}."

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as EmployeeEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}