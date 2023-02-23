package com.example.nicu.service.docxDocuments

import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.FileOutputStream

class PrimaryExamination {
    fun fillDocument(path: String){
        val doc = XWPFDocument(OPCPackage.open(path))
        for (p in doc.paragraphs) {
            val runs = p.runs
            if (runs != null) {
                for (r in runs) {
                    var text = r.getText(0)
                    if (text != null) {
                        text = text.replace("FIO", "Емурашин Данил Евгеньевич")
                        text = text.replace("NUMBEREPICRICE", "п.22")
                        r.setText(text, 0)
                    }
                }
            }
        }
        doc.write(FileOutputStream("output.docx"))
    }
}