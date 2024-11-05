/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sic.cibernet;
import ArchivosInterfaz.LogIn;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

/**
 *
 * @author reddarkshadow
 */
public class Cibernet {

    public static void main(String[] args) throws Exception {
        ArrayList<Transaccion> ListaTransaccion;
        
        //Crea el usuario
        try {
            LogSeguro.saveUser("Admin", "sic115");
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        LogIn log = new LogIn();
        log.show();
        //Creación del catalogo
        CatalogoManager manager = new CatalogoManager();
        manager.inicializarCatalogo();
        List<Cuenta> ListaCuenta =manager.cargarCuentas();
        
        
        
    }
    

}

              
