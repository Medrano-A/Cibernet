/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sic.cibernet;

/**
 *
 * @author reddarkshadow
 */

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class LogSeguro {
    private static final String DIRECTORY_PATH = System.getProperty("user.home") + "/MyAppData/Cibernet";
    private static final String FILE_PATH = DIRECTORY_PATH + "/usuarios.dat";
    
    // Constructor vacío, ya no necesita crear el directorio
    public LogSeguro() {}

    private static void createDirectoryIfNotExists() throws IOException {
        File dir = new File(DIRECTORY_PATH);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("No se pudo crear el directorio de datos de la aplicación.");
        }
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    
    public static String generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static void saveUser(String username, String password) throws IOException, NoSuchAlgorithmException {
        // Asegura la creación del directorio antes de escribir en el archivo
        createDirectoryIfNotExists();

        if (verifyUser(username, password)) {
            System.out.println("El usuario ya existe. No se puede registrar dos veces.");
            return;
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(username + ":" + salt + ":" + hashedPassword);
            writer.newLine();
        }
    }

    public static boolean verifyUser(String username, String password) throws IOException, NoSuchAlgorithmException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length != 3) continue;
                
                String storedUsername = parts[0];
                String salt = parts[1];
                String storedHash = parts[2];

                if (storedUsername.equals(username)) {
                    String inputHash = hashPassword(password, salt);
                    return inputHash.equals(storedHash);
                }
            }
        }
        return false;
    }
}
