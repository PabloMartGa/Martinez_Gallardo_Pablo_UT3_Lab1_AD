/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author DAM2P
 */
public class RegistrarEscuadrones {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/escuadron_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp = new String();
        int escReg = 1;
        
        System.out.println("=== REGISTRO DE ESCUADRONES IMPERIALES ===\n");
        
        while(resp.equalsIgnoreCase("s")){
            System.out.println("Escuadron numero: " + escReg + "\n");
            
            System.out.println("ID Escuadron: ");
            String idEscuadron = sc.nextLine();
            
            System.out.println("Nombre escuadron: ");
            String nombre = sc.nextLine();
            
            System.out.println("Sector base escuadron: ");
            String sectorBase = sc.nextLine();
            
            System.out.println("Numero cazas escuadron: ");
            int numeroCazas = sc.nextInt();
            
            registrarEscuadrones(idEscuadron, nombre, sectorBase, numeroCazas);
            
            escReg++;
            
            System.out.println("¿Desea registrar otro escuadron? (S/N): ");
            resp = sc.nextLine();
        }
    }
    
    public static void registrarEscuadrones(String idEscuadron, String nombre, String sectorBase, int numeroCazas){
        
        String sql = "INSERT INTO escuadrones_imperiales (idEscuadron, nombre, sectorBase, numeroCazas) VALUES (?,?,?,?);";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, idEscuadron);
            pstmt.setString(2, nombre);
            pstmt.setString(3, sectorBase);
            pstmt.setInt(4, numeroCazas);
            
            int registrosAfectados = pstmt.executeUpdate();
            
            System.out.println("Escuadron registrado. Registros añadidos: " + registrosAfectados);
            
        } catch (SQLException e) {
            System.err.println("Error al registrar el escuadron: " + e.getMessage());
        }
    }
}
