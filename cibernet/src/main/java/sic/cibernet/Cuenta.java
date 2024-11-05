/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @author reddarkshadow
 */
public class Cuenta implements Serializable{
    String id_cuenta;
    String tipo;
    String nombre;
    double debe;
    double haber;
    double total;
    
    public void actualizar(){
        switch (id_cuenta) {
        case "5201": // Ejemplo de cuentas de "Costos y Gastos"
        case "5202":
        case "5203":
        case "5204":
        case "5205":
        case "5206":
        case "5207":
        case "5208":
            total = debe - haber;
            BigDecimal bdc = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total=bdc.doubleValue();
            break;
        
        case "4101": // Ejemplo de cuentas de "Ingresos"
        case "4102":
        case "4103":
        case "4104":
            total = haber - debe;
            BigDecimal bdc1 = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total=bdc1.doubleValue();
            break;
        
        case "3101": // Ejemplo de cuentas de "Capital"
        case "3102":
            total = haber - debe;
            BigDecimal bdc2 = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total=bdc2.doubleValue();
            break;
        
        case "1201": // Ejemplo de cuentas de "Activo Fijo"
        case "1202":
        case "1203":
        case "1204":
        case "1205":
            total = debe - haber;
            BigDecimal bdc3 = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total=bdc3.doubleValue();
            break;
        
        case "1101": // Ejemplo de cuentas de "Activo Corriente"
        case "1102":
        case "1103":
        case "1104":
        case "1105":
        case "1106":
            total = debe - haber;
            BigDecimal bdc4 = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total = bdc4.doubleValue();
            break;
        
        case "2101": // Ejemplo de cuentas de "Pasivos Corriente"
        case "2102":
        case "2103":
            total = haber - debe;
            BigDecimal bdc5 = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            total=bdc5.doubleValue();
            break;
        
        default:
            total = 0; // Valor por defecto si el idCuenta no coincide con ninguna condición
            break;
    }
    }
    public void cerrarCuenta(){
        switch (id_cuenta) {
        case "5201": // Ejemplo de cuentas de "Costos y Gastos"
        case "5202":
        case "5203":
        case "5204":
        case "5205":
        case "5206":
        case "5207":
        case "5208":
            total = debe - haber;
            if(total>=0){
                this.haber = 0.0;
                this.debe = total;
            }else{
                this.haber = Math.abs(total);
                this.debe = 0.0;
            }
            break;
        
        case "4101": // Ejemplo de cuentas de "Ingresos"
        case "4102":
        case "4103":
        case "4104":
            total = haber - debe;
            if(total>=0){
                this.haber = total;
                this.debe = 0.0;
            }else{
                this.haber = 0.0;
                this.debe = Math.abs(total);
            }
            break;
        
        case "3101": // Ejemplo de cuentas de "Capital"
        case "3102":
            total = haber - debe;
            if(total>=0){
                this.haber = total;
                this.debe = 0.0;
            }else{
                this.haber = 0.0;
                this.debe = Math.abs(total);
            }
            break;
        
        case "1201": // Ejemplo de cuentas de "Activo Fijo"
        case "1202":
        case "1203":
        case "1204":
        case "1205":
            total = debe - haber;
            if(total>=0){
                this.haber = 0.0;
                this.debe = total;
            }else{
                this.haber = Math.abs(total);
                this.debe = 0.0;
            }
            break;
        
        case "1101": // Ejemplo de cuentas de "Activo Corriente"
        case "1102":
        case "1103":
        case "1104":
        case "1105":
        case "1106":
            total = debe - haber;
            if(total>=0){
                this.haber = 0.0;
                this.debe = total;
            }else{
                this.haber = Math.abs(total);
                this.debe = 0.0;
            }
            break;
        
        case "2101": // Ejemplo de cuentas de "Pasivos Corriente"
        case "2102":
        case "2103":
            total = haber - debe;
            if(total>=0){
                this.haber = total;
                this.debe = 0.0;
            }else{
                this.haber = 0.0;
                this.debe = Math.abs(total);
            }
            break;
        
        default:
            total = 0; // Valor por defecto si el idCuenta no coincide con ninguna condición
            break;
    }
    }

    public Cuenta(String id_cuenta, String nombre, String tipo, double debe, double haber, double total) {
        this.id_cuenta = id_cuenta;
        this.tipo = tipo;
        this.nombre = nombre;
        this.debe = debe;
        this.haber = haber;
        this.total = total;
    }

    public void setDebe(double debe) {
        this.debe += debe;
    }

    public void setHaber(double haber) {
        this.haber += haber;
    }
    
 
    
    
    public String getIdCuenta() { return id_cuenta; }
    public String getTipo() { return tipo; }
    public String getNombre() { return nombre; }
    public double getDebe() { return debe; }
    public double getHaber() { return haber; }
    public double getTotal() { return total; }
    
}
