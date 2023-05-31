package com.example.nicu.entity

import jakarta.persistence.*

@Entity
@Table(name = "course_labor")
class CourseLaborEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labor_id", nullable = true)
    var id: Long? = null,

    @Column(name = "gestational_age", nullable = true)
    var gestationalAge: String? = null,

    @Column(name = "features_course_childbirth", nullable = true)
    var featuresCourseChildbirth: String? = null,

    @Column(name = "presentation", nullable = true)
    var presentation: String? = null,

    @Column(name = "method_delivery", nullable = true)
    var methodDelivery: String? = null,

    @Column(name = "method_delivery_type", nullable = true)
    var methodDeliveryType: String? = null,

    @Column(name = "duration_labor", nullable = true)
    var durationLabor: String? = null,

    @Column(name = "straining_period", nullable = true)
    var strainingPeriod: String? = null,

    @Column(name = "anhydrous_period", nullable = true)
    var anhydrousPeriod: String? = null,

    @Column(name = "waters", nullable = true)
    var waters: String? = null,

    @Column(name = "waters_volume", nullable = true)
    var watersVolume: String? = null,

    @Column(name = "gender", nullable = true)
    var gender: String? = null,

    @Column(name = "birth_weight", nullable = true)
    var birthWeight: String? = null,

    @Column(name = "body_length", nullable = true)
    var bodyLength: String? = null,

    @Column(name = "head_circumference", nullable = true)
    var headCircumference: String? = null,

    @Column(name = "chest_circumference", nullable = true)
    var chestCircumference: String? = null,

    @Column(name = "apgar_score", nullable = true)
    var apgarScore: String? = null,

    @Column(name = "first_help", nullable = true)
    var firstHelp: String? = null,

    @Column(name = "first_help_type", nullable = true)
    var firstHelpType: String? = null,

    @Column(name = "another_first_help", nullable = true)
    var anotherFirstHelp: String? = null,

    @Column(name = "ventilation", nullable = true)
    var ventilation: String? = null,

    @Column(name = "ventilation_type", nullable = true)
    var ventilationType: String? = null,

    @Column(name = "ventilation_time", nullable = true)
    var ventilationTime: String? = null,

    @Column(name = "intubation", nullable = true)
    var intubation: String? = null,

    @Column(name = "intubation_time", nullable = true)
    var intubationTime: String? = null,

    @Column(name = "heart_massage", nullable = true)
    var heartMassage: String? = null,

    @Column(name = "heart_massage_time", nullable = true)
    var heartMassageTime: String? = null,

    @Column(name = "heart_massage_info", nullable = true)
    var heartMassageInfo: String? = "",

    @Column(name = "adrenalin", nullable = true)
    var adrenalin: String? = null,

    @Column(name = "adrenalin_time", nullable = true)
    var adrenalinTime: String? = null,

    @Column(name = "adrenalin_count", nullable = true)
    var adrenalinCount: String? = "0",

    @Column(name = "saline", nullable = true)
    var saline: String? = null,

    @Column(name = "saline_time", nullable = true)
    var salineTime: String? = null,

    @Column(name = "saline_count", nullable = true)
    var salineCount: String? = "0",

    @Column(name = "amount_assistance_delivery_room", nullable = true)
    var amountAssistanceDeliveryRoom: String? = null,
) {
}