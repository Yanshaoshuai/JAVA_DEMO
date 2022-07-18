package com.javademo.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;


public class ITextTest {
    @Test
    public void testItext01(){
        Rectangle pageSize=new Rectangle(720,720f);
//        Document document=new Document(pageSize,36f,72f,108f,180f);
        Document document=new Document(PageSize.LETTER,36f,72f,108f,180f);
        document.setMarginMirroring(true);
        document.setMarginMirroringTopBottom(true);
        try (FileOutputStream outputStream = new FileOutputStream("a.pdf")){
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("hello world"));
            document.close();
            pdfWriter.setUserunit(75000f);
        } catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
