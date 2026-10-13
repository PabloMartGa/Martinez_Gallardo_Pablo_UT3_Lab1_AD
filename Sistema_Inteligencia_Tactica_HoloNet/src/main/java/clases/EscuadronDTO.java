/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAM2P
 */
public class EscuadronDTO {
    
    private String idEscuadron;
    private String nombre;
    private String sectorBase;
    private int numeroCazas;

    public EscuadronDTO() {
    }

    public EscuadronDTO(String idEscuadron, String nombre, String sectorBase, int numeroCazas) {
        this.idEscuadron = idEscuadron;
        this.nombre = nombre;
        this.sectorBase = sectorBase;
        this.numeroCazas = numeroCazas;
    }

    /**
     * @return the idEscuadron
     */
    public String getIdEscuadron() {
        return idEscuadron;
    }

    /**
     * @param idEscuadron the idEscuadron to set
     */
    public void setIdEscuadron(String idEscuadron) {
        this.idEscuadron = idEscuadron;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sectorBase
     */
    public String getSectorBase() {
        return sectorBase;
    }

    /**
     * @param sectorBase the sectorBase to set
     */
    public void setSectorBase(String sectorBase) {
        this.sectorBase = sectorBase;
    }

    /**
     * @return the numeroCazas
     */
    public int getNumeroCazas() {
        return numeroCazas;
    }

    /**
     * @param numeroCazas the numeroCazas to set
     */
    public void setNumeroCazas(int numeroCazas) {
        this.numeroCazas = numeroCazas;
    }
    
    
    @Override
    public String toString(){
        return "ID: " + idEscuadron + " | Nombre: " + nombre + " | Sector base: " + sectorBase + " | Numero cazas: " + numeroCazas;
    }
}
