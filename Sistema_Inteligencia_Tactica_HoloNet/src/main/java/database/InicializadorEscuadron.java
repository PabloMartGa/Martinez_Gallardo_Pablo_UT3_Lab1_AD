/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DAM2P
 */
public class InicializadorEscuadron {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/escuadron_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args){
        
        String sql = "CREATE TABLE IF NOT EXISTS escuadrones_imperiales ("
                + "idEscuadron VARCHAR(100) PRIMARY KEY NOT NULL, "
                + "nombre VARCHAR(100) NOT NULL, "
                + "sectorBase VARCHAR(200) NOT NULL, "
                + "numeroCazas INT NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                Statement stmt = conn.prepareStatement(sql)){
            
            stmt.execute(sql);
            
            System.out.println("Tabla 'escuadrones_imperiales' creada correctamente");
            
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
