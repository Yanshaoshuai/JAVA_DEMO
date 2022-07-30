package com.javademo.utils;


import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.common.utils.PdfUtil;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class PdfTest {
    private final static Logger LOG = LoggerFactory.getLogger(PdfTest.class);
    @Test
    public void testGenPdfFromTemp(){
        Map<String, Object> param = Map.of("title", "Colossal", "imgPath", "colossal.jpg", "imgName", "Colossal");
        try {
            String html = FreeMarkerUtil.generateHtml("test.html", param);
            LOG.info("html:----------\n {} \n---------------",html);
            PdfUtil.createPdf(html,new FileOutputStream("test.pdf"));
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testGenPdfFromTempWithHeaderFooter(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test-footer.pdf");
            FileInputStream fileInputStream = new FileInputStream("E:\\File\\code\\JAVA_DEMO\\common\\nameddestinations.pdf");
            PdfUtil.addFooter("",fileOutputStream,fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
