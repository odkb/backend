package com.example.nicu.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "children")
class ChildEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id", nullable = false)
    var id: Long? = null,

    @Column(name = "fullName", nullable = false)
    var fullName: String? = null,

    @Column(name = "receipt_date", nullable = false)
    var receiptDate: LocalDate? = null,

    @Column(name = "arrivar_time", nullable = false)
    var arrivalTime: String? = null,

    @Column(name = "fullname_child", nullable = false)
    var fullNameChild: String? = null,

    @Column(name = "come_further_treatment_and_examination", nullable = false)
    var comeFurtherTreatmentAndExamination: String? = null,

    @Column(name = "born", nullable = false)
    var born: String? = null,

    @Column(name = "born_extra", nullable = false)
    var bornExtra: String? = null,

    @Column(name = "admission_age_month", nullable = false)
    var admissionAgeMonth: Int = 0,

    @Column(name = "admission_age_day", nullable = false)
    var admissionAgeDay: Int = 0,

    @Column(name = "birthday", nullable = false)
    var birthday: LocalDateTime? = null,

    @Column(name = "comes_from", nullable = false)
    var comesFrom: String? = null,

    @Column(name = "epid_number", nullable = false)
    var epidNumber: String? = null,

    @Column(name = "epid_number_date", nullable = false)
    var epidNumberDate: LocalDate? = null,

    @Column(name = "epid_number_diagnosis", nullable = false)
    var epidNumberDiagnosis: String? = null,

    @Column(name = "respiratory_support", nullable = false)
    var respiratorySupport: String? = null,

    @Column(name = "respiratory_support_start", nullable = false)
    var respiratorySupportStart: String? = null,

    @Column(name = "respiratory_support_end", nullable = false)
    var respiratorySupportEnd: String? = null,

    @Column(name = "drug_therapy", nullable = false)
    var drugTherapy: String? = null,

    @Column(name = "venous_access", nullable = false)
    var venousAccess: String? = null,

    @Column(name = "venous_access_start", nullable = false)
    var venousAccessStart: String? = null,

    @Column(name = "venous_access_end", nullable = false)
    var venousAccessEnd: String? = null,

    @Column(name = "venous_access_extra", nullable = false)
    var venousAccessExtra: String? = null,

    @Column(name = "phototherapy", nullable = false)
    var phototherapy: String? = null,

    @Column(name = "phototherapy_start", nullable = false)
    var phototherapyStart: String? = null,

    @Column(name = "phototherapy_end", nullable = false)
    var phototherapyEnd: String? = null,

    @Column(name = "hypothermia", nullable = false)
    var hypothermia: String? = null,

    @Column(name = "hypothermia_start", nullable = false)
    var hypothermiaStart: String? = null,

    @Column(name = "hypothermia_end", nullable = false)
    var hypothermiaEnd: String? = null,

    @Column(name = "status_at_admission", nullable = false)
    var statusAtAdmission: String? = null,

    @Column(name = "severity_due", nullable = false)
    var severityDue: String? = null,

    @Column(name = "reaction_inspection", nullable = false)
    var reactionInspection: String? = null,

    @Column(name = "additionally_reaction_inspection", nullable = false)
    var additionallyReactionInspection: String? = null,

    @Column(name = "convulsions", nullable = false)
    var convulsions: String? = null,

    @Column(name = "convulsions_type", nullable = false)
    var convulsionsType: String? = null,

    @Column(name = "muscle_tone", nullable = false)
    var muscleTone: String? = null,

    @Column(name = "additionally_muscle_tone", nullable = false)
    var additionallyMuscleTone: String? = null,

    @Column(name = "reflexes_newborn", nullable = false)
    var reflexesNewborn: String? = null,

    @Column(name = "bulbar_disorders", nullable = false)
    var bulbarDisorders: String? = null,

    @Column(name = "skull_shape", nullable = false)
    var skullShape: String? = null,

    @Column(name = "additionally_skull_shape", nullable = false)
    var additionallySkullShape: String? = null,

    @Column(name = "cephalhematomas", nullable = false)
    var cephalhematomas: String? = null,

    @Column(name = "cephalhematomas_size", nullable = false)
    var cephalhematomasSize: String? = null,

    @Column(name = "cephalhematomas_location", nullable = false)
    var cephalhematomasLocation: String? = null,

    @Column(name = "skull_sutures", nullable = false)
    var skullSutures: String? = null,

    @Column(name = "additionally_skull_sutures", nullable = false)
    var additionallySkullSutures: String? = null,

    @Column(name = "big_fontanel", nullable = false)
    var bigFontanel: String? = null,

    @Column(name = "big_fontanel_size", nullable = false)
    var bigFontanelSize: String? = null,

    @Column(name = "meningeal_symptoms", nullable = false)
    var meningealSymptoms: String? = null,

    @Column(name = "additionally_meningeal_symptoms", nullable = false)
    var additionallyMeningealSymptoms: String? = null,

    @Column(name = "status_at_admission_other", nullable = false)
    var statusAtAdmissionOther: String? = null,

    @Column(name = "skeleton_bones", nullable = false)
    var skeletonBones: String? = null,

    @Column(name = "skull_bones", nullable = false)
    var skullBones: String? = null,

    @Column(name = "clavicle", nullable = false)
    var clavicle: String? = null,

    @Column(name = "clavicle_corn", nullable = false)
    var clavicleCorn: String? = null,

    @Column(name = "clavicle_corn_location", nullable = false)
    var clavicleCornLocation: String? = null,

    @Column(name = "clavicle_corn_size", nullable = false)
    var clavicleCornSize: String? = null,

    @Column(name = "joints", nullable = false)
    var joints: String? = null,

    @Column(name = "additionally_joints", nullable = false)
    var additionallyJoints: String? = "",

    @Column(name = "skin_color", nullable = false)
    var skinColor: String? = null,

    @Column(name = "skin_color_type", nullable = false)
    var skinColorType: String? = null,

    @Column(name = "damage", nullable = false)
    var damage: String? = null,

    @Column(name = "additionally_damage", nullable = false)
    var additionallyDamage: String? = null,

    @Column(name = "rashes", nullable = false)
    var rashes: String? = null,

    @Column(name = "rashes_location", nullable = false)
    var rashesLocation: String? = null,

    @Column(name = "rashes_progres", nullable = false)
    var rashesProgres: String? = null,

    @Column(name = "pathological_formations", nullable = false)
    var pathologicalFormations: String? = null,

    @Column(name = "pathological_formations_location", nullable = false)
    var pathologicalFormationsLocation: String? = null,

    @Column(name = "pathological_formations_type", nullable = false)
    var pathologicalFormationsType: String? = null,

    @Column(name = "additionally_pathological_formations", nullable = false)
    var additionallyPathologicalFormations: String? = null,

    @Column(name = "peeling", nullable = false)
    var peeling: String? = null,

    @Column(name = "peeling_location", nullable = false)
    var peelingLocation: String? = null,

    @Column(name = "peeling_description", nullable = false)
    var peelingDescription: String? = null,

    @Column(name = "edema", nullable = false)
    var edema: String? = null,

    @Column(name = "additionally_edema", nullable = false)
    var additionallyEdema: String? = null,

    @Column(name = "edema_type", nullable = false)
    var edemaType: String? = null,

    @Column(name = "elasticity", nullable = false)
    var elasticity: String? = null,

    @Column(name = "turgor", nullable = false)
    var turgor: String? = null,

    @Column(name = "cord_remnant", nullable = false)
    var cordRemnant: String? = null,

    @Column(name = "umbilical_wound", nullable = false)
    var umbilicalWound: String? = null,

    @Column(name = "mucous", nullable = false)
    var mucous: String? = null,

    @Column(name = "mucous_humidity", nullable = false)
    var mucousHumidity: String? = null,

    @Column(name = "salivation", nullable = false)
    var salivation: String? = null,

    @Column(name = "oxygen_dependence", nullable = false)
    var oxygenDependence: String? = null,

    @Column(name = "chest_shape", nullable = false)
    var chestShape: String? = null,

    @Column(name = "chest_shape_extra", nullable = false)
    var chestShapeExtra: String? = null,

    @Column(name = "breathing_through_nose", nullable = false)
    var breathingThroughNose: String? = null,

    @Column(name = "biomechanics_respiration", nullable = false)
    var biomechanicsRespiration: String? = null,

    @Column(name = "auscultatory_picture", nullable = false)
    var auscultatoryPicture: String? = null,

    @Column(name = "auscultatory_picture_extra_text", nullable = false)
    var auscultatoryPictureExtraText: String? = null,

    @Column(name = "wheezing", nullable = false)
    var wheezing: String? = null,

    @Column(name = "crepitus", nullable = false)
    var crepitus: String? = null,

    @Column(name = "respiration_rate", nullable = false)
    var respirationRate: String? = null,

    @Column(name = "hemodynamics", nullable = false)
    var hemodynamics: String? = null,

    @Column(name = "heart_sounds", nullable = false)
    var heartSounds: String? = null,

    @Column(name = "heart_rate", nullable = false)
    var heartRate: String? = null,

    @Column(name = "noise", nullable = false)
    var noise: String? = null,

    @Column(name = "noise_extra", nullable = false)
    var noiseExtra: String? = null,

    @Column(name = "pulse_determined", nullable = false)
    var pulseDetermined: String? = null,

    @Column(name = "pale_spot_symptom", nullable = false)
    var paleSpotSymptom: String? = null,

    @Column(name = "child_blood_type", nullable = false)
    var childBloodType: String? = """Цоликлонами анти А                   анти В                       резус\n" +
            "Определена группа крови и резус принадлежность (и выбор вариантов группы крови, как при заполнении формы)\n" +
            "Кровь отправлена в отделение трансфузиологии для подтверждения.\n" +
            "                                                      Подпись врача                             ФИО""",

    @Column(name = "stomach", nullable = false)
    var stomach: String? = null,

    @Column(name = "peristalsis", nullable = false)
    var peristalsis: String? = null,

    @Column(name = "liver", nullable = false)
    var liver: String? = null,

    @Column(name = "liver_size", nullable = false)
    var liverSize: String? = null,

    @Column(name = "spleen", nullable = false)
    var spleen: String? = null,

    @Column(name = "spleen_size", nullable = false)
    var spleenSize: String? = null,

    @Column(name = "bowel_ovement", nullable = false)
    var bowelMovement: String? = null,

    @Column(name = "bowel_movement_count", nullable = false)
    var bowelMovementCount: String? = null,

    @Column(name = "bowel_movement_type", nullable = false)
    var bowelMovementType: String? = null,

    @Column(name = "feeding", nullable = false)
    var feeding: String? = null,

    @Column(name = "feed_name", nullable = false)
    var feedName: String? = null,

    @Column(name = "feeding_count", nullable = false)
    var feedingCount: String? = null,

    @Column(name = "feeding_time", nullable = false)
    var feedingTime: String? = null,

    @Column(name = "feeding_type", nullable = false)
    var feedingType: String? = null,

    @Column(name = "feeding_type_time", nullable = false)
    var feedingTypeTime: String? = null,

    @Column(name = "regurgitation", nullable = false)
    var regurgitation: String? = null,

    @Column(name = "kidneys", nullable = false)
    var kidneys: String? = null,

    @Column(name = "diuresis", nullable = false)
    var diuresis: String? = null,

    @Column(name = "diuresis_extra", nullable = false)
    var diuresisExtra: String? = null,

    @Column(name = "stimulation_diuresis", nullable = false)
    var stimulationDiuresis: String? = null,

    @Column(name = "structure_external_genitalia", nullable = false)
    var structureExternalGenitalia: String? = null,

    @Column(name = "structure_external_genitalia_gender", nullable = false)
    var structureExternalGenitaliaGender: String? = null,

    @Column(name = "structure_external_genitalia_extra", nullable = false)
    var structureExternalGenitaliaExtra: String? = null,

    @Column(name = "external_genitals_features", nullable = false)
    var externalGenitalsFeatures: String? = null,

    @Column(name = "disease_history", nullable = false)
    var diseaseHistory: String? = null,

    @Column(name = "disease_dynamics", nullable = false)
    var diseaseDynamics: String? = null,

    @Column(name = "main_syndromes_admission", nullable = false)
    var mainSyndromesAdmission: String? = null,

    @Column(name = "survey_plan", nullable = false)
    var surveyPlan: String? = null,

    @Column(name = "survey_plan_extra", nullable = false)
    var surveyPlanExtra: String? = null,

    @Column(name = "care_plan", nullable = false)
    var carePlan: String? = null,

    @Column(name = "treatment_plan", nullable = false)
    var treatmentPlan: String? = null,

    @Column(name = "parenteral_nutrition", nullable = false)
    var parenteralNutrition: String? = null,

    @Column(name = "nutrition_calculation", nullable = false)
    var nutritionCalculation: String? = null,

    @Column(name = "text_conclusion", nullable = false)
    var textConclusion: String? = null,
) {
}

