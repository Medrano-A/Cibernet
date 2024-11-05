/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import javax.swing.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoGeneralPDF {

    public static void descargarEstadoGeneral(List<Cuenta> listaCuenta) {
        Document document = new Document();
        try {
            // Ruta y nombre del archivo PDF
            String home = System.getProperty("user.home");
            String filePath = home + "/MyAppData/Cibernet/estado_general.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            // Abrir documento
            document.open();

            // Título principal
            Paragraph titulo = new Paragraph("Balance General", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Fecha: " + java.time.LocalDate.now()));
            document.add(new Paragraph(" "));

            // Crear tabla con encabezados
            PdfPTable table = new PdfPTable(3); // Columnas para Nombre, Debe y Haber
            table.setWidthPercentage(100);
            table.setWidths(new int[]{50, 25, 25}); // Anchos relativos de las columnas

            // Método para agregar subtítulos de sección
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            addSectionHeader(document, "Activo", headerFont);
            addAccountRows(table, listaCuenta, 1);

            addSectionHeader(document, "Pasivo", headerFont);
            addAccountRows(table, listaCuenta, 2);

            addSectionHeader(document, "Capital", headerFont);
            addAccountRows(table, listaCuenta, 3);

            // Calcular total general
            double totalDebe = listaCuenta.stream().mapToDouble(Cuenta::getDebe).sum();
            double totalHaber = listaCuenta.stream().mapToDouble(Cuenta::getHaber).sum();

            // Espacio y línea para total general
            document.add(new Paragraph(" "));
            document.add(new LineSeparator());
            document.add(new Paragraph(" "));

            // Total general
            PdfPCell totalCell = new PdfPCell(new Phrase("Total General"));
            totalCell.setColspan(2);
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalCell.setBorder(Rectangle.TOP);

            table.addCell(totalCell);
            table.addCell(new PdfPCell(new Phrase(String.format("%.2f", totalDebe))));
            table.addCell(new PdfPCell(new Phrase(String.format("%.2f", totalHaber))));

            // Agregar la tabla completa al documento
            document.add(table);

            // Cerrar documento
            document.close();
            JOptionPane.showMessageDialog(null, "El balance general se ha guardado en: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        }
    }

    private static void addSectionHeader(Document document, String sectionTitle, Font font) throws DocumentException {
        Paragraph sectionHeader = new Paragraph(sectionTitle, font);
        sectionHeader.setAlignment(Element.ALIGN_LEFT);
        sectionHeader.setSpacingBefore(10f);
        sectionHeader.setSpacingAfter(5f);
        document.add(sectionHeader);
    }

    private static void addAccountRows(PdfPTable table, List<Cuenta> listaCuenta, int sectionId) {
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
        double subtotalDebe = 0;
        double subtotalHaber = 0;

        for (Cuenta cuenta : listaCuenta) {
            int idCuenta = Integer.parseInt(cuenta.getIdCuenta());
            if (String.valueOf(idCuenta).startsWith(String.valueOf(sectionId))) {
                table.addCell(new PdfPCell(new Phrase(cuenta.getNombre(), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.format("%.2f", cuenta.getDebe()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.format("%.2f", cuenta.getHaber()), normalFont)));
                subtotalDebe += cuenta.getDebe();
                subtotalHaber += cuenta.getHaber();
            }
        }

        // Agregar subtotal
        PdfPCell subtotalCell = new PdfPCell(new Phrase("Subtotal " + sectionId));
        subtotalCell.setColspan(2);
        subtotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subtotalCell.setBorder(Rectangle.TOP);
        table.addCell(subtotalCell);
        table.addCell(new PdfPCell(new Phrase(String.format("%.2f", subtotalDebe))));
        table.addCell(new PdfPCell(new Phrase(String.format("%.2f", subtotalHaber))));
    }
}