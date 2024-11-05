/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;

public class BalanceGeneralTableModel extends DefaultTableModel {

    private List<Cuenta> listaFiltrada;
    private double totalDebe;
    private double totalHaber;

    public BalanceGeneralTableModel(List<Cuenta> listaCuenta) {
        // IDs de cuenta para el balance general
        String[] idsFiltro = {"1101", "1102", "1103", "1104", "1105", "1106", 
                              "1201", "1202", "1203", "1204", "1205", "2101", 
                              "2102", "2103", "3101", "3102"};
        
        // Filtrar las cuentas por los IDs especificados
        listaFiltrada = new ArrayList<>();
        for (Cuenta cuenta : listaCuenta) {
            for (String id : idsFiltro) {
                if (cuenta.getIdCuenta().equals(id)) {
                    listaFiltrada.add(cuenta);
                }
            }
        }

        // Configuración de columnas
        addColumn("Cuenta");
        addColumn("Debe");
        addColumn("Haber");

        // Llenar la tabla con los datos filtrados
        for (Cuenta cuenta : listaFiltrada) {
            addRow(new Object[] { cuenta.getNombre(), cuenta.getDebe(), cuenta.getHaber() });
            totalDebe += cuenta.getDebe();
            totalHaber += cuenta.getHaber();
        }

        // Agregar la fila de Total
        addRow(new Object[] { "Total", totalDebe, totalHaber });

        // Agregar la fila de Utilidad (Haber - Debe)
       
    }

    // Asegurarse de que las celdas no sean editables
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
