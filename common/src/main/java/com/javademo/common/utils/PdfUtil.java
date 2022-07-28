package com.javademo.common.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.OutputStream;

public class PdfUtil {
    public static void createPdf(String html, OutputStream outputStream,ConverterProperties properties){
        HtmlConverter.convertToPdf(html, outputStream,properties);
    }
    public static void createPdf(String html, OutputStream outputStream){
        HtmlConverter.convertToPdf(html, outputStream);
    }
}
