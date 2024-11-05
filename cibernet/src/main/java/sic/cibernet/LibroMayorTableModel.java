/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LibroMayorTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Tipo", "Nombre", "Debe", "Haber", "Total"};
    private final List<Cuenta> cuentas;

    public LibroMayorTableModel(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        switch (columnIndex) {
            case 0: return cuenta.getIdCuenta();
            case 1: return cuenta.getTipo();
            case 2: return cuenta.getNombre();
            case 3: return cuenta.getDebe();
            case 4: return cuenta.getHaber();
            case 5: return cuenta.getTotal();
            default: return null;
        }
    }
}
