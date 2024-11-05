/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author windows_destroyer
 */
import java.io.Serializable;
import java.util.Date;

public class RegistroDiario implements Serializable {
    private String cuenta;
    private double debe;
    private double haber;
    private String descripcion;
    private Date fecha;

    public RegistroDiario(String cuenta, double debe, double haber, String descripcion, Date fecha) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters y setters

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
