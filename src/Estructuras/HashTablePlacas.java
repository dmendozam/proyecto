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
    
    public Vehiculo[] hashTable = new Vehiculo[10]; 
    public int size = 10;
    public int cant = 0;
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
    }
    
    public boolean isFull() { 
        return (cant == size); 
    } 
  
    // primera funcion hash 
    public int hash1(int key){ 
        return (key % size); 
    } 
  
    // segunda funcion hash 
    public int hash2(int key){ 
        return (primo - (key % primo)); //********
    } 
  
    // function to insert key into hash table 
    public void insertHash(int key, Vehiculo vehi){ 
        // if hash table is full 
        if (isFull()){
            //rehashing(key);
            return; 
        }
        // get index from first hash 
        int index = hash1(key); 
        // if collision occurs 
        if (hashTable[index] != null){ 
            // get index2 from second hash 
            int index2 = hash2(key); 
            int i = 1; 
            while (i==1) { 
                // get newIndex 
                int newIndex = (index + i * index2) % size;   
                if (hashTable[newIndex] == null){ 
                    hashTable[newIndex] = vehi; 
                    break; 
                } 
                i++; 
            } 
        } 
        // if no collision occurs 
        else{
            hashTable[index] = vehi; 
        }
        cant++; 
    } 
    /*
    public void rehashing(int key){
        this.size = primoMayor(this.size*2);//***
        Vehiculo[] copia = this.hashTable;
        this.hashTable = new Vehiculo[this.size];
        for(int i = 0; i<size;i++){
            insertHash(key, copia[i]);
        }
    }
    */
    // function to search key in hash table 
    public int search(int key, String placa){ 
        int index1 = hash1(key); 
        int index2 = hash2(key);
        int i = 0;
        while (hashTable[(index1 + i * index2) % size].getPlaca() != placa) { 
            if (hashTable[(index1 + i * index2) % size] == null) { 
                return -1; 
            }
            i++; 
        } 
        int pos = (index1 + i * index2) % size;
        return pos;
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
  
    // function to display the hash table 
    /*public void displayHash() { 
        for (int i = 0; i < size; i++) { 
            if (hashTable[i] != null){ 
                //cout << i << " --> "<< hashTable[i] << endl;***********
            }
            else{
                //cout << i << endl;*************
            } 
        } 
    } */
} 
