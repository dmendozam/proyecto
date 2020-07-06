/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Modelo.Vehiculo;

/**
 *
 * @author Universidad
 */
public class HashTablePlacas {
    
    public Vehiculo[] hashTable; 
    public int size;
    public int cant;
    public int primo;

    public HashTablePlacas(Vehiculo[] hashTable, int size, int cant, int primo) {
        this.hashTable = hashTable;
        this.size = size;
        this.cant = cant;
        this.primo = primo;
    }

    public HashTablePlacas() {
        this.hashTable = new Vehiculo[10];
        this.size = 10;
        for (int i = 0; i < size; i++){ 
            hashTable[i] = null; 
        }
        this.primo = 7;
        this.cant = 0;
    }
    
    public boolean isFull() { 
        return (cant == this.size); 
    } 
  
    // primera funcion hash 
    public int hash1(int key){ 
        return (key % this.size); 
    } 
  
    // segunda funcion hash 
    public int hash2(int key){ 
        return (this.primo - (key % this.primo));
    } 
    
    // function to insert key into hash table 
    public void insertHash(int key, Vehiculo vehi){ 
        rehashing(); 
        // get index from first hash 
        int index = Math.abs(hash1(key)); 
        // if collision occurs 
        if (this.hashTable[index] != null){ 
            // get index2 from second hash 
            int index2 = hash2(key); 
            int i = 1; 
            while (1==1) { 
                // get newIndex 
                int newIndex = Math.abs((index + i * index2) % this.size);   
                if (this.hashTable[newIndex] == null){ 
                    this.hashTable[newIndex] = vehi; 
                    break; 
                } 
                i++; 
            } 
        } 
        // if no collision occurs 
        else{
            this.hashTable[index] = vehi; 
        }
        cant++; 
    } 
    
    public void rehashing(){
        double factor = (double)this.cant/(double)this.size;
        if (factor >= 0.75){    
            int sizeOld = this.size;
            this.size = primoMayor(sizeOld*2);
            Vehiculo[] copia = this.hashTable;
            this.hashTable = new Vehiculo[this.size];
            this.cant=0;
            this.primo = primoMenor(this.size);
            for(int i = 0; i< sizeOld; i++){
                if(copia[i] != null){
                    insertHash(hashCode(copia[i].getPlaca()), copia[i]);
                }
            }
        }
    }
    
    // function to search key in hash table 
    public int search(int key, String placa){ 
        int index1 = hash1(key); 
        int index2 = hash2(key);
        int i = 0;
        if(hashTable[(index1 + i * index2) % size] != null){
            while (hashTable[(index1 + i * index2) % size] != null) { 
                if (hashTable[(index1 + i * index2) % size].getPlaca().equals(placa)) { 
                    return (index1 + i * index2) % size; 
                }
                i++; 
            }
            return -1;
        }
        else{
            return -1;
        }
    } 
    
    public Vehiculo delete(int key, String placa){
        int find = search(key, placa);
        Vehiculo v;
        if(find != -1){
            v = this.hashTable[find];
            this.hashTable[find]=null;
        }else{
            return null;
        }
        return v;
    }
    
    public Vehiculo retornar(int i){
        return this.hashTable[i];
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
    public int letraANumero(String ide){
        return 1;
    }
} 
