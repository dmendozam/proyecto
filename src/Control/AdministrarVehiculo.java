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
    public LinkedList<Vehiculo> vehiculosAlquilados;

    public AdministrarVehiculo() {
        listaDeVehiculos = new LinkedList<>();
        vehiculosAlquilados= new LinkedList<>();
        llenarVehiculosIniciales();
    }

    public AdministrarVehiculo(LinkedList<Vehiculo> listaDeVehiculos,LinkedList<Vehiculo> vehiculosAlquilados) {
        this.listaDeVehiculos = listaDeVehiculos;
        this.sizeLista = listaDeVehiculos.size();
        this.vehiculosAlquilados=vehiculosAlquilados;
        llenarVehiculosIniciales();
    }
    
    
    private void llenarVehiculosIniciales(){
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "ZZZ999",7));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "ZZZ998",5));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Fortuner", 2100, "ZZZ997",7));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Sail", 800, "ZZZ996",5));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Spark", 1200, "ZZZ995",5));
        
       
    }
    public Vehiculo buscarVehiculo(Vehiculo v){ //Busqueda Binaria
    
    
    return v;
    }
    public void agregarVehiculo(Vehiculo v){
        //char letra = v.getReferencia().charAt(0);
        this.listaDeVehiculos.pushBack(v);
        
    }
    
    public void editarVehiculo(Vehiculo v){
        Vehiculo a_editar=buscarVehiculo(v);
    }
     
    public Vehiculo borrarVehiculo(Vehiculo v){
        return this.listaDeVehiculos.Eliminar(v);
    }
    public int  size(){
    return listaDeVehiculos.size();
    }
}
