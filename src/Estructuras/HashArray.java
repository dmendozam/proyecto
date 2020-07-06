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
    public int primo;
    //tolerancia 0.75
    public HashArray(int capacidad) {
        this.capacidad = capacidad;
        this.arrprin = new NodoHash[capacidad];
        this.tamano = 0;
        this.primo=7;
    }
    public boolean esPrimo(int numero){
        for(int i=2; i<numero; i++){
            if(numero%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int primoMayor(int numero){
        boolean esPrimo=false;
        while(!esPrimo){
            numero++;
            esPrimo=esPrimo(numero);
        }
        return numero;
    }
    
    public int primoMenor(int numero){
        boolean esPrimo=false;
        while(!esPrimo){
            numero--;
            esPrimo=esPrimo(numero);
        }
        return numero;
    }
    public int hashCode(String string){
        char[] arreglo = string.toCharArray();
        int hashCode = 0;
        int n = arreglo.length;
        for(int i = 0; i<n; i++){
            hashCode = hashCode + ((int)(arreglo[i])*(int)(Math.pow(31, n-(i+1))));
        }
        return Math.abs(hashCode);

        
    }  
    public void ampliar(){
        double balance=(double)tamano/(double)capacidad;
        if(balance>0.75){
            //System.out.println(balance);
            //System.out.println("Ampliando");
            NodoHash<T> arrprinneu[]=new NodoHash[primoMayor(capacidad*2)]; //copia vacia
            //System.out.println("Tamaño arrpri"+" "+arrprinneu.length);
            NodoHash<T> arrprincopia[]=arrprin; //copia arrprin
            //System.out.println("Tamaño arrpriold"+" "+arrprincopia.length);
            this.arrprin=arrprinneu;
            this.tamano=0;
            int cappre=this.capacidad;
            this.capacidad=primoMayor(capacidad*2);
            this.primo=primoMenor(this.capacidad);
            for(int l=0;l<cappre;l++){
                if(arrprincopia[l]!=null){
                    insert(arrprincopia[l].key,hashCode(arrprincopia[l].identificador),0,arrprincopia[l].identificador);
                }
                
            }
            
            //System.out.println("Ampliado "+this.capacidad);
        }
    }
    public void insert(T insertado,int hashCode,int prevcolision,String identificador){
        int posi=Math.abs(hashFunction(hashCode));
        int colision=prevcolision;
        if(arrprin[posi]==null){
           arrprin[posi]=new NodoHash<T>(insertado, identificador);
           tamano++;
           ampliar();
           //System.out.println("Insertado, numero de colisiones: "+colision);
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
                //System.out.println(colision);
                int newHashCode;
                //newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                
                if(colision>10){
                     newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                }
                
                else{ newHashCode=(hashFunction(hashCode)+colision)%this.capacidad;}
                
                insert(insertado,newHashCode,colision,identificador);
            }
        }
    }
    public int hashFunction(int hashCode){
        return  (hashCode%this.capacidad);
    }
    public int hashFunction2(int hashCode){
        
        return  (this.primo-(hashCode%this.primo));
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
                int newHashCode;
                //newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                if(colision>1){
                     newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                }
                
                else{ newHashCode=(hashFunction(hashCode)+colision)%this.capacidad;}
                
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
                //int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode, capacidad))%this.capacidad;
                int newHashCode;
                //newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                if(colision>1){
                     newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                }
                
                else{ 
                    
                    newHashCode=(hashFunction(hashCode)+colision)%this.capacidad;}
                    System.out.println("aca");
                    return delete(newHashCode,identificador,colision);
            }
        }
    }
    
    public NodoHash<T> find(int  hashCode,String identificador,int prevcolision){
        int posi=hashFunction(hashCode);
        int colision=prevcolision;
        if(arrprin[posi]==null){
            return null;
        }
        else{
            if(arrprin[posi].identificador.equals(identificador)){
                NodoHash coincide= arrprin[posi];
                return coincide;
            }
            else{
                colision++;
                int newHashCode=(hashFunction(hashCode)+colision*hashFunction2(hashCode))%this.capacidad;
                return get(newHashCode,identificador,colision);
            }
        }
    }
    
}
