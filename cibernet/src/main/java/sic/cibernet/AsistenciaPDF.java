/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AsistenciaPDF {
    private static final String RUTA_ARCHIVO = System.getProperty("user.home") + "/MyAppData/Cibernet/asistencias.pdf";

    public void generarPDF(List<Asistencia> asistencias) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(RUTA_ARCHIVO));
            document.open();

            // Encabezado
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph header = new Paragraph("Cibernet", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            // Subtítulo
            Font subHeaderFont = FontFactory.getFont(FontFactory.HELVETICA, 14);
            Paragraph subHeader = new Paragraph("Registros de Asistencias", subHeaderFont);
            subHeader.setAlignment(Element.ALIGN_CENTER);
            document.add(subHeader);

            document.add(new Paragraph("\n"));

            // Crear la tabla sin bordes
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            // Encabezados de columna
            String[] headers = {"Empleado", "Fecha", "Estado"};
            for (String headerTitle : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(headerTitle));
                headerCell.setBorder(PdfPCell.NO_BORDER);
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(headerCell);
            }

            // Llenar la tabla con los datos de asistencia
            for (Asistencia asistencia : asistencias) {
                table.addCell(createCell(asistencia.getIdEmpleado()));
                table.addCell(createCell(asistencia.getFecha().toString()));
                table.addCell(createCell(asistencia.getEstado()));
            }

            document.add(table);
            System.out.println("PDF generado correctamente en " + RUTA_ARCHIVO);

        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        } finally {
            document.close();
        }
    }

    private PdfPCell createCell(String content) {
        PdfPCell cell = new PdfPCell(new Phrase(content));
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }
}

