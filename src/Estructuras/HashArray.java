/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Control.AdministrarVehiculo;

import Modelo.Vehiculo;

/**
 *
 * @author Santiago Mendoza
 */
public class HashArray<T> {
    public NodoHash <T> arrprin[];
    public int capacidad;
    public int tamano;
    //tolerancia 0.75
    public HashArray(int capacidad) {
        this.capacidad = capacidad;
        this.arrprin = new NodoHash[capacidad];
        this.tamano = 0;
    }
    public int hashCode(String string){
        char[] arreglo = string.toCharArray();
        int hashCode = 0;
        int n = arreglo.length;
        for(int i = 0; i<n; i++){
            hashCode = hashCode + ((int)(arreglo[i])*(int)(Math.pow(3, n-(i+1))));
        }
        return Math.abs(hashCode);
    }  
    public void ampliar(){
        double balance=(double)tamano/(double)capacidad;
        if(balance>0.8){
            //System.out.println(balance);
            //System.out.println("Ampliando");
            NodoHash<T> arrprinneu[]=new NodoHash[capacidad*2]; //copia vacia
            //System.out.println("Tamaño arrpri"+" "+arrprinneu.length);
            NodoHash<T> arrprincopia[]=arrprin; //copia arrprin
            //System.out.println("Tamaño arrpriold"+" "+arrprincopia.length);
            this.arrprin=arrprinneu;
            this.tamano=0;
            int cappre=this.capacidad;
            this.capacidad=cappre*2;
            for(int l=0;l<cappre;l++){
                if(arrprincopia[l]!=null){
                    insert(arrprincopia[l].key,hashCode(arrprincopia[l].identificador),0,arrprincopia[l].identificador);
                }
                
            }
            
            //System.out.println("Ampliado "+this.capacidad);
        }
    }
    public void insert(T insertado,int hashCode,int prevcolision,String identificador){
        int posi=hashFunction(hashCode);
        int colision=prevcolision;
        if(arrprin[posi]==null){
           arrprin[posi]=new NodoHash<T>(insertado, identificador);
           tamano++;
           ampliar();
           System.out.println("Insertado");
        }
        else{
            //colision
            if(identificador.equals(arrprin[posi].identificador)){ //son iguales
                //arrprin[posi].key[arrprin[posi].size]=insertado;
                //arrprin[posi].size++;
                //ya existe marca o referencia
                
            }
            else{
                colision++;
                int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode, capacidad))%this.capacidad;
                insert(insertado,newHashCode,colision,identificador);
            }
        }
    }
    public int hashFunction(int hashCode){
        return  (hashCode%this.capacidad);
    }
    public int hashFunction2(int hashCode,int capacidad){
        return  (primo(capacidad)-(hashCode%primo(capacidad)));
    }
    
    public int primo(int capacidad){
        //y aqui que
        
        return 7;
    }
    public NodoHash<T> get(int  hashCode,String identificador,int prevcolision){
        //System.out.println("posi");
        int posi=hashFunction(hashCode);        
        //System.out.print(posi+" "+hashCode);
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
                System.out.println("newHC"+newHashCode);
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
