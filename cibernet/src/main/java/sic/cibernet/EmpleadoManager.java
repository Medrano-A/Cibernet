/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoManager {
    private final String archivoEmpleados = System.getProperty("user.home") + "/MyAppData/Cibernet/empleados.dat";

    public EmpleadoManager() {
        File file = new File(archivoEmpleados);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public void agregarEmpleado(String id, String nombre, String area, double salarioPorHora) {
        List<Empleado> empleados = cargarEmpleados();
        empleados.add(new Empleado(id, nombre, area, salarioPorHora));
        guardarEmpleados(empleados);
    }

    private void guardarEmpleados(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoEmpleados))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> cargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoEmpleados))) {
            empleados = (List<Empleado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}

