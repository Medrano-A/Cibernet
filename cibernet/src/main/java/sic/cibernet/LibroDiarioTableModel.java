/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LibroDiarioTableModel extends AbstractTableModel {
    private final List<RegistroDiario> registros;
    private final String[] columnas = {"Fecha", "Cuenta", "Debe", "Haber", "Descripción"};

    public LibroDiarioTableModel(List<RegistroDiario> registros) {
        this.registros = registros;
    }

    @Override
    public int getRowCount() {
        return registros.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegistroDiario registro = registros.get(rowIndex);
        switch (columnIndex) {
            case 0: return registro.getFecha();
            case 1: return registro.getCuenta();
            case 2: return registro.getDebe();
            case 3: return registro.getHaber();
            case 4: return registro.getDescripcion();
            default: return null;
        }
    }


}

