package com.example.nicu.service.db

import com.example.nicu.dto.child.ChildInfoDto
import com.example.nicu.dto.child.toChildInfoDto
import com.example.nicu.dto.docxDocumentsDto.PrimaryExaminationDto
import com.example.nicu.entity.ChildEntity
import com.example.nicu.repository.CrudChildRepository
import com.example.nicu.repository.PagingAndSortingChildRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ChildEntityService(
    private val pagingAndSortingChildRepository: PagingAndSortingChildRepository,
    private val crudChildRepository: CrudChildRepository,
) : EntityService<ChildEntity> {
    fun getChildrenPage(page: Int, size: Int): Page<ChildInfoDto> {
        val pageable: Pageable = PageRequest.of(page, size)
        val userPage = pagingAndSortingChildRepository.findAll(pageable)
        return userPage.map { user -> user.toChildInfoDto() }
    }

    fun importChildFromOdkbAPI(): Unit {
        // TODO: Реализовать создание шкилатрона
    }

    override fun save(dto: PrimaryExaminationDto) {
        val childEntity = dtoToEntity(dto)
        crudChildRepository.save(childEntity)
    }

    override fun dtoToEntity(dto: PrimaryExaminationDto): ChildEntity {
        val childEntity = ChildEntity()
        childEntity.fullName = dto.fullName
        childEntity.receiptDate = dto.receiptDate
        childEntity.arrivalTime = dto.arrivalTime
        childEntity.fullNameChild = dto.fullNameChild
        childEntity.comeFurtherTreatmentAndExamination = dto.comeFurtherTreatmentAndExamination
        childEntity.born = dto.born
        childEntity.bornExtra = dto.bornExtra
        childEntity.admissionAgeMonth = dto.admissionAgeMonth
        childEntity.admissionAgeDay = dto.admissionAgeDay
        childEntity.birthday = dto.birthday
        childEntity.comesFrom = dto.comesFrom
        childEntity.epidNumber = dto.EPIDNumber
        childEntity.epidNumberDate = dto.EPIDNumberDate
        childEntity.epidNumberDiagnosis = dto.EPIDNumberDiagnosis
        childEntity.respiratorySupport = dto.respiratorySupport
        childEntity.respiratorySupportStart = dto.respiratorySupportStart
        childEntity.respiratorySupportEnd = dto.respiratorySupportEnd
        childEntity.drugTherapy = dto.drugTherapy
        childEntity.venousAccess = dto.venousAccess
        childEntity.venousAccessStart = dto.venousAccessStart
        childEntity.venousAccessEnd = dto.venousAccessEnd
        childEntity.venousAccessExtra = dto.venousAccessExtra
        childEntity.phototherapy = dto.phototherapy
        childEntity.phototherapyStart = dto.phototherapyStart
        childEntity.phototherapyEnd = dto.phototherapyEnd
        childEntity.hypothermia = dto.hypothermia
        childEntity.hypothermiaStart = dto.hypothermiaStart
        childEntity.hypothermiaEnd = dto.hypothermiaEnd

        /*Стандарт осмотра*/

        childEntity.statusAtAdmission = dto.statusAtAdmission
        childEntity.severityDue = dto.severityDue?.joinToString()

        /*Общие данные*/

        childEntity.reactionInspection = dto.reactionInspection
        childEntity.additionallyReactionInspection = dto.additionallyReactionInspection
        childEntity.convulsions = dto.convulsions
        childEntity.convulsionsType = dto.convulsionsType
        childEntity.muscleTone = dto.muscleTone
        childEntity.additionallyMuscleTone = dto.additionallyMuscleTone
        childEntity.reflexesNewborn = dto.reflexesNewborn
        childEntity.bulbarDisorders = dto.bulbarDisorders
        childEntity.skullShape = dto.skullShape
        childEntity.additionallySkullShape = dto.additionallySkullShape
        childEntity.cephalhematomas = dto.cephalhematomas
        childEntity.cephalhematomasSize = dto.cephalhematomasSize
        childEntity.cephalhematomasLocation = dto.cephalhematomasLocation
        childEntity.skullSutures = dto.skullSutures
        childEntity.additionallySkullSutures = dto.additionallySkullSutures
        childEntity.bigFontanel = dto.bigFontanel
        childEntity.bigFontanelSize = dto.bigFontanelSize
        childEntity.meningealSymptoms = dto.meningealSymptoms
        childEntity.additionallyMeningealSymptoms = dto.meningealSymptoms
        childEntity.statusAtAdmissionOther = dto.statusAtAdmissionOther

        /*ОДА*/

        childEntity.skeletonBones = dto.skeletonBones
        childEntity.skullBones = dto.skullBones
        childEntity.clavicle = dto.clavicle
        childEntity.clavicleCorn = dto.clavicleCorn
        childEntity.clavicleCornLocation = dto.clavicleCornLocation
        childEntity.clavicleCornSize = dto.clavicleCornSize
        childEntity.joints = dto.joints
        childEntity.additionallyJoints = dto.additionallyJoints

        /*Кожный покров и слизистые*/

        childEntity.skinColor = dto.skinColor
        childEntity.skinColorType = dto.skinColorType
        childEntity.damage = dto.damage
        childEntity.additionallyDamage = dto.additionallyDamage
        childEntity.rashes = dto.rashes
        childEntity.rashesLocation = dto.rashesLocation
        childEntity.rashesProgres = dto.rashesProgres
        childEntity.pathologicalFormations = dto.pathologicalFormations
        childEntity.pathologicalFormationsLocation = dto.pathologicalFormationsLocation
        childEntity.pathologicalFormationsType = dto.pathologicalFormationsType
        childEntity.additionallyPathologicalFormations = dto.additionallyPathologicalFormations
        childEntity.peeling = dto.peeling
        childEntity.peelingLocation = dto.peelingLocation
        childEntity.peelingDescription = dto.peelingDescription
        childEntity.edema = dto.edema
        childEntity.additionallyEdema = dto.additionallyEdema
        childEntity.edemaType = dto.edemaType
        childEntity.elasticity = dto.elasticity
        childEntity.turgor = dto.turgor
        childEntity.cordRemnant = dto.cordRemnant?.joinToString()
        childEntity.umbilicalWound = dto.umbilicalWound
        childEntity.mucous = dto.mucous?.joinToString()
        childEntity.mucousHumidity = dto.mucousHumidity
        childEntity.salivation = dto.salivation

        /*Дыхательная сиситема*/

        childEntity.oxygenDependence = dto.oxygenDependence
        childEntity.chestShape = dto.chestShape
        childEntity.chestShapeExtra = dto.chestShapeExtra
        childEntity.breathingThroughNose = dto.breathingThroughNose
        childEntity.biomechanicsRespiration = dto.biomechanicsRespiration
        childEntity.auscultatoryPicture = dto.auscultatoryPicture?.joinToString()
        childEntity.auscultatoryPictureExtraText = dto.auscultatoryPictureExtraText
        childEntity.wheezing = dto.wheezing
        childEntity.crepitus = dto.crepitus
        childEntity.respirationRate = dto.respirationRate

        /*Сердечно-сосудистая система*/

        childEntity.hemodynamics = dto.hemodynamics
        childEntity.heartSounds = dto.heartSounds
        childEntity.heartRate = dto.heartRate
        childEntity.noise = dto.noise
        childEntity.noiseExtra = dto.noiseExtra?.joinToString()
        childEntity.pulseDetermined = dto.pulseDetermined
        childEntity.paleSpotSymptom = dto.paleSpotSymptom
        childEntity.childBloodType = dto.childBloodType
        /*Пищеварительная система*/

        childEntity.stomach = dto.stomach?.joinToString()
        childEntity.peristalsis = dto.peristalsis
        childEntity.liver = dto.liver?.joinToString()
        childEntity.liverRibs = dto.liverRibs
        childEntity.liverSize = dto.liverSize
        childEntity.spleen = dto.spleen
        childEntity.spleenSize = dto.spleenSize
        childEntity.bowelMovement = dto.bowelMovement
        childEntity.bowelMovementCount = dto.bowelMovementCount
        childEntity.bowelMovementType = dto.bowelMovementType
        childEntity.feeding = dto.feeding?.joinToString()
        childEntity.feedName = dto.feedName
        childEntity.feedingCount = dto.feedingCount
        childEntity.feedingTime = dto.feedingTime
        childEntity.feedingType = dto.feedingType
        childEntity.feedingTypeTime = dto.feedingTypeTime
        childEntity.regurgitation = dto.regurgitation

        /*Мочевидная система система*/

        childEntity.kidneys = dto.kidneys
        childEntity.diuresis = dto.diuresis
        childEntity.diuresisExtra = dto.diuresisExtra
        childEntity.stimulationDiuresis = dto.stimulationDiuresis

        /*Наружные половые органы*/

        childEntity.structureExternalGenitalia = dto.structureExternalGenitalia
        childEntity.structureExternalGenitaliaGender = dto.structureExternalGenitaliaGender
        childEntity.structureExternalGenitaliaExtra = dto.structureExternalGenitaliaExtra
        childEntity.externalGenitalsFeatures = dto.externalGenitalsFeatures

        /*Данные о заболевании*/

        childEntity.diseaseHistory = dto.diseaseHistory
        childEntity.diseaseDynamics = dto.diseaseDynamics

        /*Диагноз при поступлении*/

        childEntity.mainSyndromesAdmission = dto.mainSyndromesAdmission?.joinToString()
        childEntity.combineDiagnosis = dto.combineDiagnosis
        childEntity.diagnosisAdmissionMain = dto.diagnosisAdmissionMain?.joinToString()
        childEntity.diagnosisAdmissionMainExtra = dto.diagnosisAdmissionMainExtra
        childEntity.diagnosisAdmissionMainComplication = dto.diagnosisAdmissionMainComplication
        childEntity.diagnosisAdmissionBackground = dto.diagnosisAdmissionBackground
        childEntity.diagnosisAdmissionRelated = dto.diagnosisAdmissionRelated
        childEntity.diagnosisAdmissionGeneral = dto.diagnosisAdmissionGeneral

        /*План обследования*/

        childEntity.surveyPlan = dto.surveyPlan?.joinToString()
        childEntity.surveyPlanExtra = dto.surveyPlanExtra
        childEntity.carePlan = dto.carePlan
        childEntity.treatmentPlan = dto.treatmentPlan
        childEntity.parenteralNutrition = dto.parenteralNutrition
        childEntity.nutritionCalculation = dto.nutritionCalculation
        childEntity.textConclusion = dto.textConclusion

        return childEntity
    }

}