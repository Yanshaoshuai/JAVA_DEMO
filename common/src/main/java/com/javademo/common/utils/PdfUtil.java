package com.javademo.common.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class PdfUtil {
    public static void createPdf(String html, OutputStream outputStream, ConverterProperties properties) {
        HtmlConverter.convertToPdf(html, outputStream, properties);
    }

    public static void createPdf(String html, PdfDocument pdfDocument, ConverterProperties properties) {
        HtmlConverter.convertToPdf(html, pdfDocument, properties);
    }

    /**
     * generate header on page end
     */
    public static class HeaderEventHandler implements IEventHandler {
        private IElement header;

        public HeaderEventHandler(IElement header) {
            this.header = header;
        }

        @Override
        public void handleEvent(Event currentEvent) {
            PdfDocumentEvent documentEvent = (PdfDocumentEvent) currentEvent;
            PdfPage page = documentEvent.getPage();

            Rectangle pageSize = page.getPageSize();
            Canvas headerCanvas = new Canvas(page, new Rectangle(pageSize.getLeft(),pageSize.getTop()-30,100,100));
            if(header instanceof Image){
                headerCanvas.add((Image) header);
            }else {
                headerCanvas.add((IBlockElement) header);
            }
        }
    }

    /**
     * add footer to exist pdf
     *
     * @param footer
     * @param outputStream
     * @param inputStream
     * @throws IOException
     */
    public static void addFooter(String footer, OutputStream outputStream, InputStream inputStream) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputStream), new PdfWriter(outputStream));
        int total = pdfDocument.getNumberOfPages();
        for (int pageIndex = 1; pageIndex <= total; pageIndex++) {
            PdfPage page = pdfDocument.getPage(pageIndex);
            Rectangle pageSize = page.getPageSize();
            String footerReal;
            try {
                footerReal = FreeMarkerUtil.generateHtml(footer, Map.of("total", total, "pageIndex", pageIndex));
            } catch (IOException | TemplateException e) {
                throw new RuntimeException(e);
            }
            List<IElement> footerIElements = HtmlConverter.convertToElements(footerReal);
            Canvas footerCanvas = new Canvas(page, new Rectangle(pageSize.getRight() - 40, pageSize.getBottom() + 40,
                    40, 40));
            footerIElements.forEach(iElement -> footerCanvas.add((IBlockElement) iElement));
        }
        pdfDocument.close();
        outputStream.close();
        inputStream.close();
    }
}
