package com.example.nicu.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "employees", schema = "nicu_op")
class EmployeeEntity(

    @Id
    @Column(name = "id")
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
    var isadmin: String? = null,

)