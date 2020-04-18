/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Santiago Mendoza
 */
public class Vehiculo {
    private float kilometraje;
    private int year;
    private String marca;
    private String referencia;
    private int cilindraje;

    public Vehiculo() {
        this.kilometraje = 0;
        this.year = 1950;
        this.marca = "Ford";
        this.referencia = "F1";
        this.cilindraje = 2000;
    }

    public Vehiculo(float kilometraje, int year, String marca, String referencia, int cilindraje) {
        this.kilometraje = kilometraje;
        this.year = year;
        this.marca = marca;
        this.referencia = referencia;
        this.cilindraje = cilindraje;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public int getYear() {
        return year;
    }

    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    
}

