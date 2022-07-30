package com.javademo.common.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.layout.HtmlPageBreak;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class PdfUtil {
    public static void createPdf(String html, OutputStream outputStream,ConverterProperties properties){
        HtmlConverter.convertToPdf(html, outputStream,properties);
    }
    public static void createPdf(String html, OutputStream outputStream){
        ConverterProperties props = new ConverterProperties();
        props.setBaseUri("E:\\File\\code\\JAVA_DEMO\\common\\src\\test\\resources\\template");
        props.setCharset("utf-8");
        PdfDocument pdfDocument=new PdfDocument(new PdfWriter(outputStream));
        pdfDocument.setDefaultPageSize(PageSize.A0);
        HtmlConverter.convertToPdf(html, pdfDocument,props);
    }
    public static final String DEST = "results/events/html_header_footer.pdf";
    public static final String HEADER = "<table width=\"100%\" border=\"0\"><tr><td>Header</td><td align=\"right\">Some title</td></tr></table>";
    public static final String FOOTER = "<table width=\"100%\" border=\"0\"><tr><td>Footer</td><td align=\"right\">Some title</td></tr></table>";
    private static class VariableHeaderEventHandler implements IEventHandler {
        protected String header;

        public void setHeader(String header) {
            this.header = header;
        }

        @Override
        public void handleEvent(Event currentEvent) {
//            HtmlPageBreak
            PdfDocumentEvent documentEvent = (PdfDocumentEvent) currentEvent;
            PdfPage page = documentEvent.getPage();
            List<IElement> iElements = HtmlConverter.convertToElements(header);
            Canvas canvas = new Canvas(page, page.getPageSize());
            iElements.forEach(iElement -> canvas.add((IBlockElement) iElement));
        }
    }

    public static void createPdf(String html, OutputStream outputStream,String headerHtml,String footerHtml){
        ConverterProperties props = new ConverterProperties();
        props.setCharset("utf-8");
        PdfDocument pdfDocument=new PdfDocument(new PdfWriter(outputStream));
        pdfDocument.setDefaultPageSize(PageSize.A0);
        HtmlConverter.convertToPdf(html, pdfDocument,props);
//        HtmlConverter.convertToElements()
    }
    //todo 1.先把主体生成pdf 2.将页眉页脚html转化成elements再添加到pdf中
    //https://cloud.tencent.com/developer/article/1868920
    public static void addFooter(String footHtml, OutputStream outputStream, InputStream inputStream) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputStream), new PdfWriter(outputStream));
        Document document = new Document(pdfDocument);
        int numberOfPages = pdfDocument.getNumberOfPages();
        for (int i = 0; i <= numberOfPages ;i++){
            document.showTextAligned(new Paragraph(String.format("page %s of %s", i, numberOfPages)),
                    559, 806, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
        }
        outputStream.close();
        inputStream.close();
    }
}
