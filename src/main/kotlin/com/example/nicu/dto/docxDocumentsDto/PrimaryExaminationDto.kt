package com.example.nicu.dto.docxDocumentsDto

import com.example.nicu.DtoFieldMap
import com.example.nicu.utils.LocalDateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.time.LocalDate
import kotlin.math.abs

@Serializable
data class PrimaryExaminationDto(
    /*Паспортная часть + время и дата*/
    val fullName: String? = null,
    @Serializable(LocalDateSerializer::class)
    val receiptDate: LocalDate? = null,
    val arrivalTime: String? = null,
    val fullNameChild: String? = null,
    val comeFurtherTreatmentAndExamination: String? = null,
    val born: String? = null,
    val bornExtra: String? = null,
    var admissionAgeMonth: Int = 0,
    var admissionAgeDay: Int = 0,
    @Serializable(LocalDateSerializer::class)
    val birthday: LocalDate? = null,
    val comesFrom: String? = null,
    @SerialName("EPIDNumber")
    val EPIDNumber: String? = null,

    @Serializable(LocalDateSerializer::class)
    @SerialName("EPIDNumberDate")
    val EPIDNumberDate: LocalDate? = null,

    @SerialName("EPIDNumberDiagnosis")
    val EPIDNumberDiagnosis: String? = null,

    /*Анамнез матери*/
    val motherFullName: String? = null,
    val motherRegistration: String? = null,
    val motherAccommodation: String? = null,
    @SerialName("motherOMS")
    val motherOMS: String? = null,
    @SerialName("motherOMSNumber")
    val motherOMSNumber: String? = null,
    @SerialName("motherSNILS")
    val motherSNILS: String? = null,
    val motherPassport: String? = null,
    val motherPhoneNumber: String? = null,
    val fatherPhoneNumber: String? = null,
    val motherWithChild: String? = null,
    @Serializable(LocalDateSerializer::class)
    val motherDateBirth: LocalDate? = null,
    val familyStatus: String? = null,
    val maternalIllnesses: String? = null,
    val motherBloodGroup: String? = null,
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
    val previousPregnanciesExtra: String? = null,
    val steroidProphylaxis: String? = null,
    val steroidProphylaxisExtra: String? = null,

    /*Течение родов*/

    val gestationalAge: String? = null,
    val featuresCourseChildbirth: String? = null,
    val presentation: String? = null,
    val methodDelivery: String? = null,
    val methodDeliveryType: String? = null,
    val durationLabor: String? = null,
    val strainingPeriod: String? = null,
    val anhydrousPeriod: String? = null,
    val waters: List<String>? = null,
    val watersVolume: String? = null,
    val gender: String? = null,
    val birthWeight: String? = null,
    val length: String? = null,
    val headCircumference: String? = null,
    val chestCircumference: String? = null,
    val apgarScore: String? = null,

    /*Объем помощи*/

    val firstHelp: String? = null,
    val firstHelpType: List<String>? = null,
    val anotherFirstHelp: String? = null,

    val ventilation: String? = null,
    val ventilationType: List<String>? = null,
    val ventilationTime: String? = null,

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
    val cordRemnant: List<String>? = null,
    val umbilicalWound: String? = null,
    val mucous: List<String>? = null,
    val mucousHumidity: String? = null,
    val salivation: String? = null,

    /*Дыхательная сиситема*/

    val oxygenDependence: String? = null,
    val chestShape: String? = null,
    val chestShapeExtra: String? = null,
    val breathingThroughNose: String? = null,
    val biomechanicsRespiration: String? = null,
    val auscultatoryPicture: List<String>? = null,
    val auscultatoryPictureExtraText: String? = null,
    val wheezing: String? = null,
    val crepitus: String? = null,
    val respirationRate: String? = null,

    /*Сердечно-сосудистая система*/

    val hemodynamics: String? = null,
    val heartSounds: String? = null,
    val heartRate: String? = null,
    val noise: String? = null,
    val noiseExtra: List<String>? = null,
    val pulseDetermined: String? = null,
    val paleSpotSymptom: String? = null,
    val childBloodType: String = """Цоликлонами анти А                   анти В                       резус\n" +
            "Определена группа крови и резус принадлежность (и выбор вариантов группы крови, как при заполнении формы)\n" +
            "Кровь отправлена в отделение трансфузиологии для подтверждения.\n" +
            "                                                      Подпись врача                             ФИО""",

    /*Пищеварительная система*/

    val stomach: List<String>? = null,
    val peristalsis: String? = null,
    val liver: List<String>? = null,
    val liverRibs: String? = null,
    val liverSize: String? = null,
    val spleen: String? = null,
    val spleenSize: String? = null,
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
    val diuresis: String? = null,
    val diuresisExtra: String? = null,
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

    var combineDiagnosis: String? = null,
    val diagnosisAdmissionMain: List<String>? = null,
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
) : DocumentDto {
    init {
        admissionAgeMonth = abs((receiptDate?.month?.value ?: 0) - (birthday?.month?.value ?: 0))
        admissionAgeDay = abs((receiptDate?.dayOfMonth ?: 0) - (birthday?.dayOfMonth ?: 0))
        if (diagnosisAdmissionMain != null && diagnosisAdmissionMain.size > 1) {
            combineDiagnosis = "Комбинированное основное заболевание"
        }
    }

    @Transient
    override val dtoFieldMap = DtoFieldMap(this)
    override fun getFieldValue(fieldName: String): String = dtoFieldMap.getFieldValue(this, fieldName)
}
