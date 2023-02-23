package com.example.nicu.service

import com.example.nicu.entity.EmployeeEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class EmployeeDetailsImpl(
    var employeeUsername: String?,
    @JsonIgnore
    var employeePassword: String?,
    var firstName: String?,
    var lastName: String?,
    var secondName: String?,
    ) : UserDetails {

    companion object {
        fun build(employeeEntity: EmployeeEntity): EmployeeDetailsImpl {
            return EmployeeDetailsImpl(
                employeeEntity.username,
                employeeEntity.password,
                employeeEntity.firstName,
                employeeEntity.lastName,
                employeeEntity.secondName,
            )
        }
    }
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {

        return mutableListOf()
    }

    override fun getPassword(): String? {
        return employeePassword
    }

    override fun getUsername(): String? {
        return employeeUsername
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun getFullName() : String {
        return "$lastName ${firstName?.get(0)}. ${secondName?.get(0)}."
    }
}