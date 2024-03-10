package com.nri.trial.Oprations.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
// import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

    public ByteArrayInputStream createPdf() {
        String title = "Hello BotOp78";
        String body = "Please do not play bgmi";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document docs = new Document();
        PdfWriter.getInstance(docs, out);
        try {
            docs.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph para = new Paragraph(title, titleFont);
            para.setAlignment(Element.ALIGN_CENTER);

            docs.add(para);

            Font paraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30);
            Paragraph paraBody = new Paragraph(body, paraFont);
            paraBody.setAlignment(Element.ALIGN_LEFT);

            docs.add(paraBody);

        //use PdfTable class to add tables
        // PdfTable


            docs.close();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
