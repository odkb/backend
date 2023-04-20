package com.example.nicu.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDate

@Entity
@Table(name = "mothers")
class MotherEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mother_id", nullable = true)
    var id: Long? = null,

    @Column(name = "mother_fullname", nullable = true)
    var motherFullName: String? = null,

    @Column(name = "mother_registration", nullable = true)
    var motherRegistration: String? = null,

    @Column(name = "mother_accommodation", nullable = true)
    var motherAccommodation: String? = null,

    @Column(name = "mother_oms", nullable = true)
    var motherOms: String? = null,

    @Column(name = "mother_oms_number", nullable = true)
    var motherOmsNumber: String? = null,

    @Column(name = "mother_snils", nullable = true)
    var motherSnils: String? = null,

    @Column(name = "mother_passport", nullable = true)
    var motherPassport: String? = null,

    @Column(name = "mother_phone_number", nullable = true)
    var motherPhoneNumber: String? = null,

    @Column(name = "father_phone_number", nullable = true)
    var fatherPhoneNumber: String? = null,

    @Column(name = "mother_with_child", nullable = true)
    var motherWithChild: String? = null,

    @Column(name = "mother_datebirth", nullable = true)
    var motherDateBirth: LocalDate? = null,

    @Column(name = "family_status", nullable = true)
    var familyStatus: String? = null,

    @Column(name = "maternal_illnesses", nullable = true)
    var maternalIllnesses: String? = null,

    @Column(name = "mother_blood_group", nullable = true)
    var motherBloodGroup: String? = null,

    @Column(name = "erythrocyte_body", nullable = true)
    var erythrocyteBody: String? = null,

    @Column(name = "hiv_Testing_mother", nullable = true)
    var hivTestingMother: String? = null,

    @Column(name = "hiv_Testing_father", nullable = true)
    var hivTestingFather: String? = null,

    @Column(name = "maternal_infectious_history", nullable = true)
    var maternalInfectiousHistory: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MotherEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}