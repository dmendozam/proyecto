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
public class HashArray<T> {
    public NodoHash <T> arrprin[];
    int capacidad;
    int tamano;
    //tolerancia 0.75
    public HashArray(int capacidad) {
        this.capacidad = capacidad;
        this.arrprin = new NodoHash[capacidad];
        this.tamano = 0;
    }
    public void ampliar(){
        if(tamano/capacidad>0.75){
            NodoHash<T> copia[]=new NodoHash[capacidad*2];
            for(int i=0;i<this.tamano;i++){
                copia[i]=this.arrprin[i];
            }
            this.capacidad=capacidad*2;
            this.arrprin=copia;
        }
    }
    public void insert(T insertado,long hashCode,int prevcolision,String identificador){
        int posi=hashFunction(hashCode);
        int colision=prevcolision;
        if(arrprin[posi]==null){
           arrprin[posi]=new NodoHash<T>(insertado, identificador);
           tamano++;
           ampliar();
        }
        else{
            //colision
            if(identificador.equals(arrprin[posi].identificador)){ //son iguales
                //arrprin[posi].key[arrprin[posi].size]=insertado;
                //arrprin[posi].size++;
                //ya existe marca o referencia
                return;
            }
            else{
                colision++;
                int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode, capacidad))%this.capacidad;
                insert(insertado,newHashCode,colision,identificador);
            }
        }
    }
    public int hashFunction(long hashCode){
        return (int) (hashCode%this.capacidad);
    }
    public int hashFunction2(long hashCode,int capacidad){
        return (int) (primo(capacidad)-(hashCode%primo(capacidad)));
    }
    
    public int primo(int capacidad){
        //y aqui que
        return 7;
    }
    public NodoHash<T> get(long  hashCode,String identificador,int prevcolision){
        System.out.println("posi");
        int posi=hashFunction(hashCode);
        
        int colision=prevcolision;
        if(arrprin[posi]==null){
            return null;
        }
        else{
            if(arrprin[posi].identificador.equals(identificador)){
                return arrprin[posi];
            }
            else{
                colision++;
                int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode, capacidad))%this.capacidad;
                return get(newHashCode,identificador,colision);
            }
        }
    }
    public NodoHash<T> delete(int  hashCode,String identificador,int prevcolision){
        int posi=hashFunction(hashCode);
        int colision=prevcolision;
        if(arrprin[posi]==null){
            return null;
        }
        else{
            if(arrprin[posi].identificador.equals(identificador)){
                NodoHash eliminado= arrprin[posi];
                arrprin[posi]=null;
                return eliminado;
            }
            else{
                colision++;
                int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode, capacidad))%this.capacidad;
                return get(newHashCode,identificador,colision);
            }
        }
    }
    
}
