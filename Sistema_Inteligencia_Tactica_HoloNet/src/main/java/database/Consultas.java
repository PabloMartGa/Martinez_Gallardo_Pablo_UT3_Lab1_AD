/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import clases.EscuadronDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAM2P
 */
public class Consultas {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/escuadron_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== BÚSQUEDA DE ESCUADRONES IMPERIALES ===\n");
        
        System.out.println("Introduce el ID del escuadron que desea localizar:");
        int filtro = sc.nextInt();
        
        List<EscuadronDTO> escuadronesFiltrados = buscarEscuadronesImperiales(filtro);
        
        for(EscuadronDTO esc: escuadronesFiltrados){
            System.out.println(esc);
        }
        
    }
    
    public static List<EscuadronDTO> buscarEscuadronesImperiales(int idEscuadron){
        
        String sql = "SELECT * FROM escuadrones_imperiales WHERE idEscuadron = ?;";
        
        ArrayList<EscuadronDTO> escuadronesBuscados = new ArrayList();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, idEscuadron);
            
            try (ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    String id = rs.getString("idEscuadron");
                    String nombre = rs.getString("nombre");
                    String sector = rs.getString("sectorBase");
                    int cazas = rs.getInt("numeroCazas");
                    
                    escuadronesBuscados.add(new EscuadronDTO(sector, nombre, sector, cazas));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al buscar los escuadrones imperiales: " + e.getMessage());
        }
        
        return escuadronesBuscados;
    }
}
