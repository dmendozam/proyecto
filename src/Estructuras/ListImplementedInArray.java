/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Modelo.Vehiculo;

/**
 *
 * @author Santiago Mendoza
 */
public class ListImplementedInArray {
    
    private Vehiculo array[];
    int size;
    int capacidad;

    public ListImplementedInArray(Vehiculo[] array, int size, int capacidad) {
        this.array = array;
        this.size = size;
        this.capacidad = capacidad;
    }

    public ListImplementedInArray() {
        this.capacidad=10;
        this.array = new Vehiculo[capacidad];
        this.size = 0;
        
    }
    public void agregar(Vehiculo entrante){
        if(size==capacidad){
            aumentarCapacidad();
        }
        array[size]=entrante;
        size++;
    }
    public void aumentarCapacidad(){
        Vehiculo nuevoarray[]= new Vehiculo[capacidad*2];
        int tamañoInstante=array.length;
        for(int i=0;i<tamañoInstante;i++){
            nuevoarray[i]=array[i];
       
        }
        array=nuevoarray;
        capacidad=capacidad*2;
        
    }
    
    public int buscarIndice(Vehiculo buscado){
        
        for(int i=0;i<size;i++){
            if(array[i]==buscado){
                return i;
            }
        }
        
        return -1;
    }
    public void update(Vehiculo aActualizar,Vehiculo actualizacion){
        int indice=buscarIndice(aActualizar);
        if(indice==-1){
            System.out.println("No existe el vehiculo que se quiere editar");
        }
        else{
        array[indice]=actualizacion;
        }
    }
    public void delete(Vehiculo borrar){
        int indice=buscarIndice(borrar);
        array[indice]= null;
        size--;
        
    }

    public Vehiculo[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setArray(Vehiculo[] array) {
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
}

