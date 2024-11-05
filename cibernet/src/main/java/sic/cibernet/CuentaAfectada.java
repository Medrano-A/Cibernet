/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

import java.io.Serializable;

/**
 *
 * @author reddarkshadow
 */
public class CuentaAfectada implements Serializable {
    
    double debe;
    double haber;
    Cuenta cuentaPadre;
    public void actualizar(){
        cuentaPadre.actualizar();
    }

    public CuentaAfectada(double debe, double haber, Cuenta cuentaPadre) {
        this.debe = debe;
        this.haber = haber;
        this.cuentaPadre = cuentaPadre;
    }
    
}
