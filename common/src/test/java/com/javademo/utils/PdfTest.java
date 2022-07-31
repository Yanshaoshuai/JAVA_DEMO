package com.javademo.utils;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.common.utils.PdfUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class PdfTest {
    private final static Logger LOG = LoggerFactory.getLogger(PdfTest.class);

    @Test
    public void testHeader() {
        File file = FileUtils.getFile("E:\\File\\code\\JAVA_DEMO\\common\\src\\test\\resources\\template\\colossal.jpg");
        byte[] bytes;
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String base64str = Base64.getEncoder().encodeToString(bytes);
        Map<String, Object> param = Map.of("title", "Colossal", "imgPath", "data:image/jpeg;base64," + base64str, "imgName", "Colossal");
        try {
            String html = FreeMarkerUtil.generateHtml("test.html", param);
            LOG.info("html:----------\n {} \n---------------", html);
            String headerHtml = FreeMarkerUtil.generateHtml("header.html", null);
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream("test.pdf")));
//            List<IElement> iElements = HtmlConverter.convertToElements(headerHtml);
//            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PdfUtil.HeaderEventHandler(iElements.get(0)));
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PdfUtil.HeaderEventHandler(new Image(ImageDataFactory.create(bytes))));
            ConverterProperties props = new ConverterProperties();
            PdfUtil.createPdf(html, pdfDocument, props);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testFooter(){
        try {
            PdfUtil.addFooter("footer.html",new FileOutputStream("test-with-footer.pdf"),new FileInputStream("E:\\File\\code\\JAVA_DEMO\\common\\test.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
