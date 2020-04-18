/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Santiago Mendoza
 */
public class Usuario {
    private String nombre;
    private String usuario;                         //faltan atributos de la clase
    private String clave;
    private LinkedList<Vehiculo> listaVehiculosArrendados;
    

    public Usuario() {
        this.nombre = "John Doe";
        this.usuario = "jdoe";
        this.clave = "5678";
        this.listaVehiculosArrendados= new LinkedList<Vehiculo>();
   
        
        
    }

    public Usuario(String nombre, String usuario, String clave, LinkedList<Vehiculo> listaVehiculosArrendados) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.listaVehiculosArrendados= listaVehiculosArrendados;
        
    

    
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

   

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



    
}

