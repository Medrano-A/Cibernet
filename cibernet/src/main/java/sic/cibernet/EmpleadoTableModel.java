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

public class EmpleadoTableModel extends AbstractTableModel {
    private final List<Empleado> empleados;
    private final String[] columnas = {"ID", "Nombre", "Área", "Salario por Hora"};

    public EmpleadoTableModel(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado = empleados.get(rowIndex);
        switch (columnIndex) {
            case 0: return empleado.getId();
            case 1: return empleado.getNombre();
            case 2: return empleado.getArea();
            case 3: return empleado.getSalarioPorHora();
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Hacer las celdas no editables
    }
}
