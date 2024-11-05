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

public class Empleado implements Serializable {
    private String id;
    private String nombre;
    private String area;
    private double salarioPorHora;

    public Empleado(String id, String nombre, String area, double salarioPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.salarioPorHora = salarioPorHora;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public double getSalarioPorHora() { return salarioPorHora; }
    public void setSalarioPorHora(double salarioPorHora) { this.salarioPorHora = salarioPorHora; }
}

