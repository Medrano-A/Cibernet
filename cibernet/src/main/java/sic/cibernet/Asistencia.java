/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author reddarkshadow
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Asistencia implements Serializable {
    private String idEmpleado;
    private LocalDate fecha;
    private String estado; // Presente, Ausente, Tarde

    public Asistencia(String idEmpleado, LocalDate fecha, String estado) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}

