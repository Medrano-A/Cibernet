/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author reddarkshadow
 */
public class CatalogoManager {
    private final String filePath;

    public CatalogoManager() {
        this.filePath = System.getProperty("user.home") + "/MyAppData/Cibernet/catalogo.dat";
    }

    // Método para inicializar el archivo con cuentas predeterminadas
    public void inicializarCatalogo() {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                List<Cuenta> cuentasIniciales = getCuentasPredeterminadas();
                guardarCuentas(cuentasIniciales);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Cuentas predeterminadas
    private List<Cuenta> getCuentasPredeterminadas() {
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta("1101", "Caja", "Activo Corriente", 0, 0, 0));
        cuentas.add(new Cuenta("1102", "Bancos", "Activo Corriente", 0, 0, 0));
        cuentas.add(new Cuenta("1103","Inventarios","Activo Corriente",0,0,0));
        cuentas.add(new Cuenta("1104","Cuentas por Cobrar","Activo Corriente",0,0,0));
        cuentas.add(new Cuenta("1105","Licencias de Software","Activo Corriente",0,0,0));
        cuentas.add(new Cuenta("1106","IVA Crédito Fiscal","Activo Corriente",0,0,0));
        cuentas.add(new Cuenta("1201","Equipos de Cómputo","Activo Fijo",0,0,0));
        cuentas.add(new Cuenta("1202","Equipos de Impresión y Escaneo","Activo Fijo",0,0,0));
        cuentas.add(new Cuenta("1203","Servidores y Equipos de Red","Activo Fijo",0,0,0));
        cuentas.add(new Cuenta("1204","Mobiliario y Equipo de Oficina","Activo Fijo",0,0,0));
        cuentas.add(new Cuenta("1205","Mejoras al Inmueble","Activo Fijo", 0, 0, 0));
        cuentas.add(new Cuenta("2101","Proveedores","Pasivos Corriente", 0, 0, 0));
        cuentas.add(new Cuenta("2102", "IVA Débito Fiscal","Pasivos Corriente", 0, 0, 0));
        cuentas.add(new Cuenta("2103","Préstamos Bancarios","Pasivos Corriente", 0, 0, 0));
        cuentas.add(new Cuenta("3101","Capital","Capital", 0, 0, 0));
        cuentas.add(new Cuenta("3102", "Utilidad del Ejercicio","Capital", 0, 0, 0));
        cuentas.add(new Cuenta("4101", "Ingresos por Acceso a Internet","Ingresos", 0, 0, 0));
        cuentas.add(new Cuenta("4102","Ingresos por Servicios de Impresión y Escaneo","Ingresos", 0, 0, 0));
        cuentas.add(new Cuenta("4103", "Ingresos por Venta de Accesorios","Ingresos", 0, 0, 0));
        cuentas.add(new Cuenta("4104", "Otros Ingresos","Ingresos", 0, 0, 0));
        cuentas.add(new Cuenta("5101", "Costo de Ventas de Accesorios","Costos y Gasto", 0, 0, 0));
        cuentas.add(new Cuenta("5201", "Gastos de Sueldos y Salarios","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5202", "Gastos de Mantenimiento de Equipos","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5203", "Gastos de Suministros","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5204", "Gastos de Licencias de Software","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5205", "Servicios Públicos","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5206", "Gastos de Depreciación","Costos y Gastos", 0, 0, 0));
        cuentas.add(new Cuenta("5207", "Pérdidas en Copias", "Costos y Gastos", 0, 0, 0));
        return cuentas;
    }

    // Guardar cuentas en el archivo
    public void guardarCuentas(List<Cuenta> cuentas) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Cuenta cuenta : cuentas) {
                oos.writeObject(cuenta);
            }
        }
    }

    // Cargar cuentas desde el archivo
    public List<Cuenta> cargarCuentas() {
        List<Cuenta> catalogo = new ArrayList<>();
        File file = new File(filePath);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    catalogo.add((Cuenta) ois.readObject());
                }
            } catch (EOFException e) {
                // Fin del archivo alcanzado
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return catalogo;
    }
}
    

