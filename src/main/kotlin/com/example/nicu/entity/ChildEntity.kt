package com.example.nicu.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "mainApp_childrens")
class ChildEntity(
    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "historyID")
    var historyID: String? = null,

    @Column(name = "is_superuser")
    var isSuperuser: String?,

    @Column(name = "incomeDateTime")
    var incomeDateTime: String,

    @Column(name = "viewWhit")
    var viewWhit: String? = null,

    @Column(name = "fullName")
    var fullName: String,

    @Column(name = "birthDateTime")
    var birthDateTime: String,

    @Column(name = "gender")
    var gender: String? = null,

    @Column(name = "weight")
    var weight: String? = null,

    @Column(name = "lenght")
    var lenght: String? = null,

    @Column(name = "headCircle")
    var headCircle: String? = null,

    @Column(name = "breastCircle")
    var breastCircle: String? = null,

    @Column(name = "bloodType")
    var bloodType: String? = null,

    @Column(name = "obstetricAnamnesis")
    var obstetricAnamnesis: String? = null,

    @Column(name = "motherDiseases")
    var motherDiseases: String? = null,

    @Column(name = "pregnancyCourse")
    var pregnancyCourse: String? = null,

    @Column(name = "vprFoetus")
    var vprFoetus: String? = null,

    @Column(name = "isSteroidPrevention")
    var isSteroidPrevention: String? = null,

//    @Column(name = "steroidPrevention")
//    var steroidPrevention: String? = null,

    @Column(name = "steroidPreventionDate")
    var steroidPreventionDate: String? = null,

    @Column(name = "pregnancy")
    var pregnancy: String? = null,

    @Column(name = "childbirth")
    var childbirth: String? = null,

    @Column(name = "childbirthCourse")
    var childbirthCourse: String? = null,

    @Column(name = "childbirthCourse2")
    var childbirthCourse2: String? = null,

    @Column(name = "gestation")
    var gestation: String? = null,

    @Column(name = "childbirthText")
    var childbirthText: String? = null,

    @Column(name = "childbirthDurationHours")
    var childbirthDurationHours: String? = null,

    @Column(name = "childbirthDurationMinutes")
    var childbirthDurationMinutes: String? = null,

    @Column(name = "attemptsPeriods")
    var attemptsPeriods: String? = null,

    @Column(name = "liquidlessPeriodDays")
    var liquidlessPeriodDays: String? = null,

    @Column(name = "liquidlessPeriodHours")
    var liquidlessPeriodHours: String? = null,

    @Column(name = "liquidlessPeriodMinuts")
    var liquidlessPeriodMinuts: String? = null,

    @Column(name = "liquidColor")
    var liquidColor: String? = null,

    @Column(name = "liquidsTransp")
    var liquidsTransp: String? = null,

    @Column(name = "liquidsSmell")
    var liquidsSmell: String? = null,

    @Column(name = "apgar1")
    var apgar1: String? = null,

    @Column(name = "apgar2")
    var apgar2: String? = null,

    @Column(name = "apgar3")
    var apgar3: String? = null,

    @Column(name = "apgar4")
    var apgar4: String? = null,

    @Column(name = "motherbirthDate")
    var motherbirthDate: String? = null,

    @Column(name = "motherAge")
    var motherAge: String? = null,

    @Column(name = "motherLastName")
    var motherLastName: String? = null,

    @Column(name = "motherFirstName")
    var motherFirstName: String?,

    @Column(name = "motherSecondName")
    var motherSecondName: String,

    @Column(name = "city")
    var city: String? = null,

    @Column(name = "address")
    var address: String? = null,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "phone2")
    var phone2: String? = null,

    @Column(name = "motherHIV")
    var motherHIV: String? = null,

    @Column(name = "motherHIVterapy")
    var motherHIVterapy: String? = null,

    @Column(name = "motherHIVisPositive")
    var motherHIVisPositive: String? = null,

    @Column(name = "fatherHIV")
    var fatherHIV: String? = null,

    @Column(name = "ferstSteps")
    var ferstSteps: String? = null,

    @Column(name = "heating")
    var heating: String? = null,

    @Column(name = "sanVDP")
    var sanVDP: String? = null,

    @Column(name = "obtiranie")
    var obtiranie: String? = null,

    @Column(name = "termoFilm")
    var termoFilm: String? = null,

    @Column(name = "o2Therapy")
    var o2Therapy: String? = null,

    @Column(name = "o2TherapyComent")
    var o2TherapyComent: String? = null,

    @Column(name = "cPAP")
    var cPAP: String? = null,

    @Column(name = "cPAPType")
    var cPAPType: String? = null,

    @Column(name = "cPAPTherapyComent")
    var cPAPTherapyComent: String? = null,

    @Column(name = "ivl")
    var ivl: String? = null,

    @Column(name = "ivlType")
    var ivlType: String? = null,

    @Column(name = "ivlTherapyComent")
    var ivlTherapyComent: String? = null,

    @Column(name = "it")
    var it: String? = null,

    @Column(name = "itSanation")
    var itSanation: String? = null,

    @Column(name = "itContIVL")
    var itContIVL: String? = null,

    @Column(name = "itExtubation")
    var itExtubation: String? = null,

    @Column(name = "itTherapyEtt")
    var itTherapyEtt: String? = null,

    @Column(name = "itTherapyDeep")
    var itTherapyDeep: String? = null,

    @Column(name = "itTherapyComent")
    var itTherapyComent: String? = null,

    @Column(name = "subfractant")
    var subfractant: String? = null,

    @Column(name = "subfractantVol")
    var subfractantVol: String? = null,

    @Column(name = "subfractantMethod")
    var subfractantMethod: String? = null,

    @Column(name = "subfractantComent")
    var subfractantComent: String? = null,

    @Column(name = "cpr")
    var cpr: String? = null,

    @Column(name = "cprComent")
    var cprComent: String? = null,

    @Column(name = "drugs")
    var drugs: String? = null,

    @Column(name = "drugsAdr")
    var drugsAdr: String? = null,

    @Column(name = "drugsMethod")
    var drugsMethod: String? = null,

    @Column(name = "drugsLiq")
    var drugsLiq: String? = null,

    @Column(name = "birthState")
    var birthState: String? = null,

    @Column(name = "transportPreporation")
    var transportPreporation: String? = null,

    @Column(name = "diseaseCourse")
    var diseaseCourse: String?,

    @Column(name = "transportation")
    var transportation: String,

    @Column(name = "transportationMethod")
    var transportationMethod: String? = null,

    @Column(name = "transportationCase")
    var transportationCase: String? = null,

    @Column(name = "pip")
    var pip: String? = null,

    @Column(name = "peep")
    var peep: String? = null,

    @Column(name = "fio2")
    var fio2: String? = null,

    @Column(name = "ti")
    var ti: String? = null,

    @Column(name = "r")
    var r: String? = null,

    @Column(name = "flow")
    var flow: String? = null,

    @Column(name = "vt")
    var vt: String? = null,

    @Column(name = "spo2")
    var spo2: String? = null,

    @Column(name = "heartBeat")
    var heartBeat: String? = null,

    @Column(name = "bloodPreasureSis")
    var bloodPreasureSis: String? = null,

    @Column(name = "bloodPreasurDia")
    var bloodPreasurDia: String? = null,

    @Column(name = "bloodPreasurAvg")
    var bloodPreasurAvg: String? = null,

    @Column(name = "incomeWeight")
    var incomeWeight: String? = null,

    @Column(name = "incomTemper")
    var incomTemper: String? = null,

    @Column(name = "commonState")
    var commonState: String? = null,

    @Column(name = "commonStateOther")
    var commonStateOther: String? = null,

    @Column(name = "consciousness")
    var consciousness: String? = null,

    @Column(name = "sedation")
    var sedation: String? = null,

    @Column(name = "viewReactions")
    var viewReactions: String? = null,

    @Column(name = "pupil")
    var pupil: String? = null,

    @Column(name = "msrf")
    var msrf: String? = null,

    @Column(name = "br1")
    var br1: String? = null,

    @Column(name = "br2")
    var br2: String? = null,

    @Column(name = "br")
    var br: String? = null,

    @Column(name = "spasms")
    var spasms: String? = null,

    @Column(name = "photoreaction")
    var photoreaction: String? = null,

    @Column(name = "skinColor")
    var skinColor: String? = null,

    @Column(name = "skinTurgor")
    var skinTurgor: String? = null,

    @Column(name = "skinHipostas")
    var skinHipostas: String? = null,

    @Column(name = "skinNavel")
    var skinNavel: String? = null,

    @Column(name = "skinOther")
    var skinOther: String? = null,

    @Column(name = "breath")
    var breath: String? = null,

    @Column(name = "breathFreq")
    var breathFreq: String? = null,

    @Column(name = "breathBiomech")
    var breathBiomech: String? = null,

    @Column(name = "breathO2")
    var breathO2: String? = null,

    @Column(name = "breathMakrota")
    var breathMakrota: String? = null,

    @Column(name = "breathMakrotaVol")
    var breathMakrotaVol: String? = null,

    @Column(name = "breathMakrotaCont")
    var breathMakrotaCont: String? = null,

    @Column(name = "breathResperator")
    var breathResperator: String? = null,

    @Column(name = "breathETT1")
    var breathETT1: String? = null,

    @Column(name = "breathETT2")
    var breathETT2: String? = null,

    @Column(name = "breathAscultivno")
    var breathAscultivno: String? = null,

    @Column(name = "breathKOS")
    var breathKOS: String? = null,

    @Column(name = "breathPH")
    var breathPH: String? = null,

    @Column(name = "breathPCO2")
    var breathPCO2: String?,

    @Column(name = "breathPO2")
    var breathPO2: String,

    @Column(name = "breathABE")
    var breathABE: String? = null,

    @Column(name = "auscultivno")
    var auscultivno: String? = null,

    @Column(name = "hSystemHemodinaica")
    var hSystemHemodinaica: String? = null,

    @Column(name = "hSystemTones")
    var hSystemTones: String? = null,

    @Column(name = "hSystemTonesTypes")
    var hSystemTonesTypes: String? = null,

    @Column(name = "hSystemINVAPGE")
    var hSystemINVAPGE: String? = null,

    @Column(name = "hSystemNoise")
    var hSystemNoise: String? = null,

    @Column(name = "hSystemPulse")
    var hSystemPulse: String? = null,

    @Column(name = "hSystemSpot")
    var hSystemSpot: String? = null,

    @Column(name = "hSystemBeat")
    var hSystemBeat: String? = null,

    @Column(name = "hSystembloodPreasureSis")
    var hSystembloodPreasureSis: String? = null,

    @Column(name = "hSystembloodPreasurDia")
    var hSystembloodPreasurDia: String? = null,

    @Column(name = "hSystembloodPreasurAvg")
    var hSystembloodPreasurAvg: String? = null,

    @Column(name = "hSystemSatO2")
    var hSystemSatO2: String? = null,

    @Column(name = "stomath")
    var stomath: String? = null,

    @Column(name = "liver")
    var liver: String? = null,

    @Column(name = "spleen")
    var spleen: String? = null,

    @Column(name = "defication")
    var defication: String? = null,

    @Column(name = "food")
    var food: String? = null,

    @Column(name = "stomathContain")
    var stomathContain: String? = null,

    @Column(name = "stul")
    var stul: String? = null,

    @Column(name = "diurez")
    var diurez: String? = null,

    @Column(name = "gentals")
    var gentals: String? = null,

    @Column(name = "vol")
    var vol: String? = null,

    @Column(name = "weg")
    var weg: String? = null,

    @Column(name = "spe")
    var spe: String? = null,

    @Column(name = "urinogenitalComent")
    var urinogenitalComent: String? = null,

    @Column(name = "glico")
    var glico: String? = null,

    @Column(name = "K")
    var K: String? = null,

    @Column(name = "Na")
    var Na: String? = null,

    @Column(name = "Hb")
    var Hb: String? = null,

    @Column(name = "Lact")
    var Lact: String? = null,

    @Column(name = "TSBi")
    var TSBi: String? = null,

    @Column(name = "Hct")
    var Hct: String? = null,

    @Column(name = "sindromDiag")
    var sindromDiag: String? = null,

    @Column(name = "preDiag")
    var preDiag: String? = null,

    @Column(name = "respSupport")
    var respSupport: String? = null,

    @Column(name = "insfusion")
    var insfusion: String? = null,

    @Column(name = "blood")
    var blood: String? = null,

    @Column(name = "invazpge")
    var invazpge: String? = null,

    @Column(name = "drugsTreatment")
    var drugsTreatment: String? = null,

    @Column(name = "foodTreatment")
    var foodTreatment: String? = null,

    @Column(name = "antibacter")
    var antibacter: String? = null,

    @Column(name = "treatmentComent")
    var treatmentComent: String? = null,

    @Column(name = "oak")
    var oak: String? = null,

    @Column(name = "oam")
    var oam: String? = null,

    @Column(name = "bclBlood")
    var bclBlood: String? = null,

    @Column(name = "rentgen")
    var rentgen: String? = null,

    @Column(name = "neirodream")
    var neirodream: String? = null,

    @Column(name = "uziOrgans")
    var uziOrgans: String? = null,

    @Column(name = "uziHeart")
    var uziHeart: String? = null,

    @Column(name = "bacterView")
    var bacterView: String? = null,

    @Column(name = "gazBlood")
    var gazBlood: String? = null,

    @Column(name = "gazBloodFreq")
    var gazBloodFreq: String? = null,

    @Column(name = "otherAnalyses")
    var otherAnalyses: String? = null,

    @Column(name = "otherAnalysesComent")
    var otherAnalysesComent: String? = null,

    @Column(name = "otherConsult")
    var otherConsult: String? = null,

    @Column(name = "otherConsultComent")
    var otherConsultComent: String? = null,

    @Column(name = "navelCatetr")
    var navelCatetr: String? = null,

    @Column(name = "navelCatetrComent")
    var navelCatetrComent: String? = null,

    @Column(name = "gvl")
    var gvl: String? = null,

    @Column(name = "gvlComent")
    var gvlComent: String? = null,

    @Column(name = "clavicleCatetr")
    var clavicleCatetr: String? = null,

    @Column(name = "clavicleCatetrComent")
    var clavicleCatetrComent: String? = null,

    @Column(name = "venflon")
    var venflon: String? = null,

    @Column(name = "venflonComent")
    var venflonComent: String? = null,

    @Column(name = "venesection")
    var venesection: String? = null,

    @Column(name = "venesectionComent")
    var venesectionComent: String? = null,

    @Column(name = "instalationDateTime")
    var instalationDateTime: String? = null,

    @Column(name = "instalationNumbr")
    var instalationNumbr: String? = null,

    @Column(name = "instalationDeep")
    var instalationDeep: String? = null,

    @Column(name = "veinAccessComent")
    var veinAccessComent: String? = null,

    @Column(name = "isFunctNormal")
    var isFunctNormal: String? = null,

    @Column(name = "bloodType2")
    var bloodType2: String? = null,

    @Column(name = "cyclon1")
    var cyclon1: String? = null,

    @Column(name = "cyclon2")
    var cyclon2: String? = null,

    @Column(name = "cyclon3")
    var cyclon3: String? = null,

    @Column(name = "leaving")
    var leaving: String? = null,

    @Column(name = "respLeavingSupport")
    var respLeavingSupport: String? = null,

    @Column(name = "resuscitationPlace")
    var resuscitationPlace: String? = null,

    @Column(name = "respirator")
    var respirator: String? = null,

    @Column(name = "created_at")
    var created_at: String? = null,

    @Column(name = "updated_at")
    var updated_at: String? = null,

) {
}