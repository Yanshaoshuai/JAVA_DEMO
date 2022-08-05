package com.javademo.utils;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.layout.HtmlPageBreak;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.common.utils.PdfUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
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
    private static String html;
    private static byte[] imageBytes;


    @BeforeAll
    public static void init() {
        File file = FileUtils.getFile("E:\\File\\code\\JAVA_DEMO\\common\\src\\test\\resources\\template\\colossal.jpg");
        try {
            imageBytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String base64str = Base64.getEncoder().encodeToString(imageBytes);
        Map<String, Object> param = Map.of("title", "Colossal", "imgPath", "data:image/jpeg;base64," + base64str, "imgName", "Colossal");
        try {
            html = FreeMarkerUtil.generateHtml("test.html", param);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPdf() {
        LOG.info("html:----------\n {} \n---------------", html);
        ConverterProperties props = new ConverterProperties();
        byte[] pdfBytes = PdfUtil.createPdf(html, props);
        try {
            FileUtils.writeByteArrayToFile(new File("test.pdf"),pdfBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testHeader() {

        try {
            LOG.info("html:----------\n {} \n---------------", html);
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream("test.pdf")));
            pdfDocument.setDefaultPageSize(PageSize.A4);
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PdfUtil.HeaderEventHandler(new Image(ImageDataFactory.create(imageBytes))));
            ConverterProperties props = new ConverterProperties();
            PdfUtil.createPdf(html, pdfDocument, props);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFooter() {
        try {
            PdfUtil.addFooter("footer.html", new FileOutputStream("test-with-footer.pdf"), new FileInputStream("E:\\File\\code\\JAVA_DEMO\\common\\test.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMargin() {
        try {
            LOG.info("html:----------\n {} \n---------------", html);
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream("test.pdf")));
            pdfDocument.setDefaultPageSize(PageSize.A4);
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PdfUtil.HeaderEventHandler(new Image(ImageDataFactory.create(imageBytes))));
            Document document = new Document(pdfDocument);
            document.setMargins(50, 50, 50, 100);
            List<IElement> elements = HtmlConverter.convertToElements(html);
            for (IElement element : elements) {
                if (element instanceof IBlockElement) {
                    document.add((IBlockElement) element);
                } else if (element instanceof HtmlPageBreak) {
                    document.add((HtmlPageBreak) element);
                }
            }
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
