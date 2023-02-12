package com.example.nicu.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "mainApp_persons")
class EmployeeEntity(

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "last_login")
    var lastLogin: Instant? = null,

    @Column(name = "is_superuser")
    var isSuperuser: String?,

    @Column(name = "username")
    var username: String,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "is_staff")
    var isStaff: String? = null,

    @Column(name = "is_active")
    var isActive: String? = null,

    @Column(name = "date_joined")
    var dateJoined: Instant? = null,

    @Id
    @Column(name = "id")
    var id: String? = null,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "secondName")
    var secondName: String? = null,

    @Column(name = "timeZ")
    var timeZ: String? = null,

    @Column(name = "params")
    var params: String? = null,

    @Column(name = "drem_id")
    var dremId: String? = null,

    @Column(name = "roles_id")
    var rolesId: String? = null,

    @Column(name = "reanimation_id")
    var reanimationId: String? = null,

    @Column(name = "specialisation")
    var specialisation: String? = null
)