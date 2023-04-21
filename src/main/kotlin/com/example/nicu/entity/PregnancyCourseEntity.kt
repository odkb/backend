package com.example.nicu.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime


@Entity
@Table(name = "pregnancy_course")
class PregnancyCourseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mother_id", nullable = true)
    var id: Long? = null,

    @Column(name = "pregnancy", nullable = true)
    var pregnancy: String? = null,

    @Column(name = "child_birth", nullable = true)
    var childBirth: LocalDateTime? = null,

    @Column(name = "previous_pregnancies", nullable = true)
    var previousPregnancies: String? = null,

    @Column(name = "data_siblings", nullable = true)
    var dataSiblings: String? = null,

    @Column(name = "features_course_pregnancy", nullable = true)
    var featuresCoursePregnancy: String? = null,

    @Column(name = "previous_pregnanciee_extra", nullable = true)
    var previousPregnanciesExtra: String? = null,

    @Column(name = "steroid_prophylaxis", nullable = true)
    var steroidProphylaxis: String? = null,

    @Column(name = "steroid_prophylaxis_extra", nullable = true)
    var steroidProphylaxisExtra: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PregnancyCourseEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}