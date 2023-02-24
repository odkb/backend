package com.example.nicu.service.docxDocuments

import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.FileOutputStream

val arrayTemplates = arrayListOf<String>("receiptDate", "arrivalTime", "fullNameChild", "comeFurtherTreatmentAndExamination",
    "born", "admissionAge", "comesFrom", "EPIDNumber", "motherDateBirth", "familyStatus", "maternalIllnesses",
    "motherBloodGroup", "HIVTestingMother", "HIVTestingFather", "maternalInfectiousHistory", "pregnancy",
    "childbirth", "previousPregnancies", "dataSiblings", "featuresCoursePregnancy", "steroidProphylaxis",
    "gestationalAge", "featuresCourseChildbirth", "presentation", "methodDelivery", "durationLabor",
    "strainingPeriod", "anhydrousPeriod", "waters", "gender", "birthWeight", "length", "headCircumference",
    "chestCircumference", "apgarScore", "amountAssistanceDeliveryRoom", "diseaseHistory", "respiratorySupport",
    "drugTherapy", "deeding", "venousAccess", "phototherapy", "hypothermia", "statusAtAdmission", "severityDue",
    "reactionInspection", "convulsions", "muscleTone", "reflexesNewborn", "bulbarDisorders", "skullShape",
    "cephalhematomas", "skullSutures", "bigFontanel", "meningealSymptoms", "statusAtAdmissionOther", "skeletonBones",
    "skullBones", "clavicle", "joints", "skinColor", "damage", "hematomas", "rashes", "pathologicalFormations",
    "peeling", "edema", "elasticity", "turgor", "cordRemnant", "umbilicalWound", "mucous", "oxygenDependence",
    "chestShape", "breathingThroughNose", "biomechanicsRespiration", "auscultatoryPicture", "respirationRate",
    "hemodynamics", "heartSounds", "heartRate", "noise", "pulseDetermined", "paleSpotSymptom", "stomach",
    "peristalsis", "liver", "spleen", "feeding", "bowelMovement", "kidneys", "diuresis", "stimulationDiuresis",
    "structureExternalGenitalia", "externalGenitalsFeatures", "mainSyndromesAdmission", "diagnosisAdmission",
    "surveyPlan", "carePlan", "treatmentPlan", "parenteralNutrition", "nutritionCalculation", "childBloodType",
    "textConclusion",)

class PrimaryExamination {
    fun fillDocument(path: String){
        val doc = XWPFDocument(OPCPackage.open("src/main/resources/templates/primary_examination_OPN.docx"))
        val paragraphs =  doc.paragraphs
        for (param in arrayTemplates){
            for (p in paragraphs) {
                val runs = p.runs
                if (runs != null) {
                    for (r in runs) {
                        var text = r.getText(0)
                        if (text != null) {
                            text = text.replace(param, "0")
                            r.setText(text, 0)
                        }
                    }
                }
            }
        }
    }
}