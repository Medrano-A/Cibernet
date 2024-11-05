/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author windows_destroyer
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class RegistroDiarioManager {
    private final String filePath = System.getProperty("user.home") + "/MyAppData/Cibernet/diario.dat";
    private final File archivoDiario = new File(filePath);

    // Constructor: crea el directorio si no existe
    public RegistroDiarioManager() {
        File directorio = archivoDiario.getParentFile();
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    // Método para recuperar registros desde catalogo.dat
    public ArrayList<RegistroDiario> cargarRegistros() {
        ArrayList<RegistroDiario> registros = new ArrayList<>();
        if (archivoDiario.exists()) {
            try (FileInputStream fis = new FileInputStream(archivoDiario);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                registros = (ArrayList<RegistroDiario>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    // Método para guardar registros en catalogo.dat
    public void guardarRegistros(ArrayList<RegistroDiario> registros) {
        try (FileOutputStream fos = new FileOutputStream(archivoDiario);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(registros);
            System.out.println("Registros guardados exitosamente en diario.dat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un nuevo registro
    public void agregarRegistro(String cuenta, double debe, double haber, String descripcion) {
        ArrayList<RegistroDiario> registros = cargarRegistros();
        RegistroDiario nuevoRegistro = new RegistroDiario(cuenta, debe, haber, descripcion, new Date());
        registros.add(nuevoRegistro);
        guardarRegistros(registros);
    }
}
