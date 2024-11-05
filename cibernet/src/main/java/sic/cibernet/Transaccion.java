/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author reddarkshadow
 */
public class Transaccion implements Serializable {
    String fecha;
    double monto;
    String descripcion;
    ArrayList<CuentaAfectada> List;
    public void actualizar(){
        for (CuentaAfectada elemento : List) {
            elemento.actualizar();
        }
    }

    public Transaccion(String fecha, double monto, String descripcion, ArrayList<CuentaAfectada> List) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.List = List;
    }
    
    
    
    
}
