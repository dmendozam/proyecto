/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Estructuras.LinkedList;
import Modelo.Usuario;
import Modelo.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Santiago Mendoza
 */
public class AdministrarVehiculo {
    public LinkedList<Vehiculo> listaDeVehiculos;
    int sizeLista=0;

    public AdministrarVehiculo() {
        listaDeVehiculos = new LinkedList<Vehiculo>();
        llenarVehiculosIniciales();
    }

    public AdministrarVehiculo(LinkedList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
        llenarVehiculosIniciales();
    }
    
    
    private void llenarVehiculosIniciales(){
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "ABC123",7));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Runner", 4500, "ABC124",5));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Fortuner", 2100, "ABC125",7));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Sail", 800, "AFE484",5));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Spark", 1200, "TYU477",5));
        
       
    }
    public Vehiculo buscarVehiculo(Vehiculo v){ //Busqueda Binaria
    
    
    return v;
    }
    public void agregarVehiculo(Vehiculo v){
        //char letra = v.getReferencia().charAt(0);
        listaDeVehiculos.pushBack(v);
        sizeLista=sizeLista+1;
    }
    
    public void editarVehiculo(Vehiculo v){
        Vehiculo a_editar=buscarVehiculo(v);
    }
     
    public void borrarVehiculo(Vehiculo v){
        
    }
    public int  size(){
    return sizeLista;
    }
}
