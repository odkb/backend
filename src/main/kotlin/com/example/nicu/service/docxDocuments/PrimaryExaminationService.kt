package com.example.nicu.service.docxDocuments

import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.json.JSONException
import org.json.JSONObject
import java.io.FileOutputStream

val arrayTemplates = arrayListOf<String>(
    "receiptDate", "arrivalTime", "fullNameChild", "comeFurtherTreatmentAndExamination",
    "born", "admissionAge", "dateToOPN", "comesFrom", "EPIDNumber", "motherDateBirth", "familyStatus", "maternalIllnesses",
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
    "textConclusion",
)

class PrimaryExaminationService {
    fun fillDocument(path: String, data : JSONObject): XWPFDocument{
        val doc = XWPFDocument(OPCPackage.open(path))
        val paragraphs =  doc.paragraphs
        val timeout = System.currentTimeMillis()
        for (param in arrayTemplates){
            for (p in paragraphs) {
                val runs = p.runs
                if (runs != null) {
                    for (r in runs) {
                        var text = r.getText(0)
                        if (text != null) {
                            try{
                                text = text.replace(param, data.getString(param) )
                                r.setText(text, 0)
                            }
                            catch (e: JSONException){
                                continue
                            }
                        }
                    }
                }
            }
        }
        println(System.currentTimeMillis() - timeout)
//        doc.write(FileOutputStream("output.docx"))
        return doc
    }
}