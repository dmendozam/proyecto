/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.LinkedList;
import Modelo.Usuario;
import Modelo.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Santiago Mendoza
 */
public class AdministrarVehiculo {
        private LinkedList<Vehiculo> listaDeVehiculos;

    public AdministrarVehiculo() {
        listaDeVehiculos = new LinkedList<Vehiculo>();
        llenarVehiculosIniciales();
    }

    public AdministrarVehiculo(LinkedList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
        llenarVehiculosIniciales();
    }
    
    private void llenarVehiculosIniciales(){
        listaDeVehiculos.pushBack(new Vehiculo(0, 0, "Toyota", "Pradp", 4500, "ABC123"));
        
       
    }
    public Vehiculo buscarVehiculo(Vehiculo v){ //Busqueda Binaria
    
    
    return v;
    }
    public void agregarVehiculo(Vehiculo v){
        char letra = v.getReferencia().charAt(0);
        
        
        //listaDeVehiculos.push
    }
    
    public void editarVehiculo(Vehiculo v){
        Vehiculo a_editar=buscarVehiculo(v);
    }
     
    public void borrarVehiculo(Vehiculo v){
        
    }
}
