package com.example.nicu.dto.docxDocumentsDto

import com.example.nicu.DtoFieldMap
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class PrimaryExaminationDto(
    /*Паспортная часть + время и дата*/

    val fullName: String? = null,

    val receiptDate: String? = null,
    val arrivalTime: String? = null,
    val fullNameChild: String? = null,
    val comeFurtherTreatmentAndExamination: String? = null,
    val born: String? = null,
    val admissionAge: String? = null,
    @SerialName("dateToOPN") val dateToOPN: String? = null,
    val comesFrom: String? = null,
    @SerialName("EPIDNumber") val EPIDNumber: String? = null,
    @SerialName("EPIDNumberDate") val EPIDNumberDate: String? = null,
    @SerialName("EPIDNumberDiagnosis") val EPIDNumberDiagnosis: String? = null,

    /*Анамнез матери*/

    val motherDateBirth: String? = null,
    val familyStatus: String? = null,
    val maternalIllnesses: String? = null,
    val motherBloodGroup: String? = "Цоликлонами",
    val erythrocyteBody: String? = null,
    @SerialName("HIVTestingMother")
    val HIVTestingMother: String? = null,
    @SerialName("HIVTestingFather")
    val HIVTestingFather: String? = null,
    val maternalInfectiousHistory: String? = null,

    /*Течение беременности*/

    val pregnancy: String? = null,
    val childbirth: String? = null,
    val previousPregnancies: String? = null,
    val dataSiblings: String? = null,
    val featuresCoursePregnancy: String? = null,
    val steroidProphylaxis: String? = null,

    /*Течение родов*/

    val gestationalAge: String? = null,
    val featuresCourseChildbirth: String? = null,
    val presentation: String? = null,
    val headPresentation: String? = "",
    val methodDelivery: String? = null,
    val methodDeliveryType: String? = "",
    val durationLabor: String? = null,
    val strainingPeriod: String? = null,
    val anhydrousPeriod: String? = null,
    val waters: String? = null,
    val watersVolume: String? = "",
    val gender: String? = null,
    val birthWeight: String? = null,
    val length: String? = null,
    val headCircumference: String? = null,
    val chestCircumference: String? = null,
    val apgarScore: String? = null,

    /*Объем помощи*/

    val firstHelp: String? = null,
    val firstHelpType: List<String>? = null,
    val anotherFirstHelp: String? = "",

    val ventilation: String? = null,
    val ventilationType: List<String>? = null,
    val ventilationTime: String? = null,
    val ventilationInfo: String? = null,

    val intubation: String? = null,
    val intubationTime: String? = null,

    val heartMassage: String? = null,
    val heartMassageTime: String? = null,
    val heartMassageInfo: String? = "",

    val adrenalin: String? = null,
    val adrenalinTime: String? = null,
    val adrenalinCount: String? = "0",

    val saline: String? = null,
    val salineTime: String? = null,
    val salineCount: String? = "0",

    val amountAssistanceDeliveryRoom: String? = null,

    /*До ОПН проведено лечение*/

    val respiratorySupport: String? = null,
    val respiratorySupportStart: String? = null,
    val respiratorySupportEnd: String? = null,
    val drugTherapy: String? = null,
    val venousAccess: String? = null,
    val venousAccessStart: String? = null,
    val venousAccessEnd: String? = null,
    val venousAccessExtra: String? = null,
    val phototherapy: String? = null,
    val phototherapyStart: String? = null,
    val phototherapyEnd: String? = null,
    val hypothermia: String? = null,
    val hypothermiaStart: String? = null,
    val hypothermiaEnd: String? = null,

    /*Стандарт осмотра*/

    val statusAtAdmission: String? = null,
    val severityDue: List<String>? = null,
    val reactionInspection: String? = null,
    val additionallyReactionInspection: String? = null,
    val convulsions: String? = null,
    val convulsionsType: String? = null,
    val muscleTone: String? = null,
    val additionallyMuscleTone: String? = null,
    val reflexesNewborn: String? = null,
    val bulbarDisorders: String? = null,
    val skullShape: String? = null,
    val additionallySkullShape: String? = null,
    val cephalhematomas: String? = null,
    val cephalhematomasSize: String? = null,
    val cephalhematomasLocation: String? = null,
    val skullSutures: String? = null,
    val additionallySkullSutures: String? = null,
    val bigFontanel: String? = null,
    val bigFontanelSize: String? = null,
    val meningealSymptoms: String? = null,
    val additionallyMeningealSymptoms: String? = null,
    val statusAtAdmissionOther: String? = null,

    /*ОДА*/

    val skeletonBones: String? = null,
    val skullBones: String? = null,
    val clavicle: String? = null,
    val clavicleCorn: String? = null,
    val clavicleCornLocation: String? = null,
    val clavicleCornSize: String? = null,
    val joints: String? = null,
    val additionallyJoints: String? = "",

    /*Кожный покров и слизистые*/

    val skinColor: String? = null,
    val skinColorType: String? = null,
    val damage: String? = null,
    val additionallyDamage: String? = null,
    val hematomas: String? = null,
    val additionallyHematomas: String? = null,
    val rashes: String? = null,
    val rashesLocation: String? = null,
    val rashesProgres: String? = null,
    val pathologicalFormations: String? = null,
    val pathologicalFormationsLocation: String? = null,
    val pathologicalFormationsType: String? = null,
    val additionallyPathologicalFormations: String? = null,
    val peeling: String? = null,
    val peelingLocation: String? = null,
    val peelingDescription: String? = null,
    val edema: String? = null,
    val additionallyEdema: String? = null,
    val edemaType: String? = null,
    val elasticity: String? = null,
    val turgor: String? = null,
    val cordRemnant: String? = null,
    val umbilicalWound: String? = null,
    val mucous: String? = null,
    val mucousHumidity: String? = null,

    /*Дыхательная сиситема*/

    val oxygenDependence: String? = null,
    val chestShape: String? = null,
    val chestShapeExtra: String? = null,
    val breathingThroughNose: String? = null,
    val biomechanicsRespiration: String? = null,
    val auscultatoryPicture: String? = null,
    val auscultatoryPictureExtra: String? = null,
    val auscultatoryPictureExtraText: String? = null,
    val wheezing: String? = null,
    val crepitus: String? = null,
    val respirationRate: String? = null,

    /*Сердечно-сосудистая система*/

    val hemodynamics: String? = null,
    val heartSounds: String? = null,
    val heartRate: String? = null,
    val noise: String? = null,
    val noiseExtra: String? = null,
    val pulseDetermined: String? = null,
    val paleSpotSymptom: String? = null,
    val childBloodType: String? = "Цоликлонами",

    /*Пищеварительная система*/

    val stomach: List<String>? = null,
    val peristalsis: String? = null,
    val liver: String? = null,
    val liverSize: String? = null,
    val spleen: String? = null,
    val bowelMovement: String? = null,
    val bowelMovementCount: String? = null,
    val bowelMovementType: String? = null,
    val feeding: List<String>? = null,
    val feedName: String? = null,
    val feedingCount: String? = null,
    val feedingTime: String? = null,
    val feedingType: String? = null,
    val feedingTypeTime: String? = null,
    val regurgitation: String? = null,

    /*Мочевидная система система*/

    val kidneys: String? = null,
    val diuresisMl: String? = null,
    val diuresisKg: String? = null,
    val diuresisH: String? = null,
    val stimulationDiuresis: String? = null,

    /*Наружные половые органы*/

    val structureExternalGenitalia: String? = null,
    val structureExternalGenitaliaGender: String? = null,
    val structureExternalGenitaliaExtra: String? = null,
    val externalGenitalsFeatures: String? = null,

    /*Данные о заболевании*/

    val diseaseHistory: String? = null,
    val diseaseDynamics: String? = null,
    val mainSyndromesAdmission: List<String>? = null,

    val diagnosisMain: String? = null,
    val diagnosisMainExtra: String? = null,
    val diagnosisMainComplication: String? = null,
    val diagnosisBackground: String? = null,
    val diagnosisRelated: String? = null,
    val diagnosisGeneral: String? = null,

    val diagnosisAdmissionMain: String? = null,
    val diagnosisAdmissionMainExtra: String? = null,
    val diagnosisAdmissionMainComplication: String? = null,
    val diagnosisAdmissionBackground: String? = null,
    val diagnosisAdmissionRelated: String? = null,
    val diagnosisAdmissionGeneral: String? = null,

    /*План обследования*/

    val surveyPlan: List<String>? = null,
    val surveyPlanExtra: String? = null,
    val carePlan: String? = null,
    val treatmentPlan: String? = null,
    val parenteralNutrition: String? = null,
    val nutritionCalculation: String? = null,
    val textConclusion: String? = null,
) : DocsDto {
    @Transient
    private val dtoFieldMap = DtoFieldMap(PrimaryExaminationDto::class)
    override fun getFieldValue(fieldName: String): String =
        dtoFieldMap.getFieldValue(this, fieldName)
}
