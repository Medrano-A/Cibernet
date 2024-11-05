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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaManager {
    private final String archivoAsistencia = System.getProperty("user.home") + "/MyAppData/Cibernet/asistencia.dat";

    public AsistenciaManager() {
        File file = new File(archivoAsistencia);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public void registrarAsistencia(String nombreEmpleado, LocalDate fecha, String estado) {
        List<Asistencia> asistencias = cargarAsistencias();
        asistencias.add(new Asistencia(nombreEmpleado, fecha, estado));
        guardarAsistencias(asistencias);
    }

    private void guardarAsistencias(List<Asistencia> asistencias) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoAsistencia))) {
            oos.writeObject(asistencias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Asistencia> cargarAsistencias() {
        List<Asistencia> asistencias = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoAsistencia))) {
            asistencias = (List<Asistencia>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return asistencias;
    }
}

