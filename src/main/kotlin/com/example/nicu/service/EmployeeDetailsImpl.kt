package com.example.nicu.service

import com.example.nicu.entity.EmployeeEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails



class EmployeeDetailsImpl(
//    var id: String?,
    var employeeUsername: String?,
    @JsonIgnore
    var  employeePassword: String?,

    ) : UserDetails {

    companion object {
        fun build(employeeEntity: EmployeeEntity): EmployeeDetailsImpl {
            return EmployeeDetailsImpl(
//                employeeEntity.id,
                employeeEntity.username,
                employeeEntity.password,
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
}