/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Mendoza
 * @param <T>
 */
public class LinkedList<T> {
    public Nodo<T> top;
    public Nodo<T> tail;
    private int size;

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return this.top == null;
    }
    
    public void pushFront(T key) {
        Nodo<T> nodo = new Nodo(key, this.top, null);
        if(!this.isEmpty()){ 
            this.top = nodo;  
        }else{
            this.top = nodo;
            this.tail = nodo;
        }
        this.size++;
    }
    
    public void pushBack(T key) {
        Nodo<T> nodo = new Nodo<>(key, null, this.tail); 
        if(!this.isEmpty()){
            this.tail.next=nodo;  //esto no estaba
            this.tail = nodo; 
        } else{
            this.tail = nodo;
            this.top = nodo;
        }
        this.size++; 
    }
    
    public T popFront() {
        T temp;
        if(isEmpty()) {
            return null;
        } else {
            temp = top.key;
            top = top.next; 
            size--;
            if(top==null){
                tail=null;
            }
            return temp;
        }
    }
    
    public T popBack() {
        T temp;
        if(isEmpty()) {
            return null;
        } else {
            temp = tail.key;
            tail = tail.last; 
            size--;
            return temp;
        }
    }

    public T topFront() {
        if(isEmpty()) {
            return null;
        } else {
            return top.key;
        }
    }
    
    public T topBack() {
        if(isEmpty()) {
            return null;
        } else {
            return tail.key;
        }
    }    
    public T Eliminar(T sacar){
        Nodo<T> sentinela= new Nodo<>();
        sentinela=top;
        
        int tamañoinstante=size();
        for(int i=0;i<tamañoinstante;i++){
            
            //System.out.println(i);
            //System.out.println("el key es"+sentinela.key);
            //System.out.println(sentinela.key+" "+sacar);
            if(sentinela.key==sacar){
                //System.out.println("paso");
                if(sentinela==top){
                    popFront();
                    break;
                }
                else if(sentinela==tail){
                    //System.out.println("hola");
                    popBack();
                    break;
                }
                else{
                    sentinela.last.next=sentinela.next;
                    sentinela.next.last=sentinela.last;
                    size--;
                    break;
     
                }
            }
            sentinela=sentinela.next;
        }
        return sentinela.key;
        
        
    }
    public T valueAtPosition(int position){
        T value = null; 
        Nodo<T> nodo = this.top;
        if (position>this.size){
            System.out.println("La posision que se busca es mayor a la longitud de la lista");
            return null;
        }else{
            for(int i=0; i<position; i++){
                value = nodo.key;
                nodo = nodo.next;
            }
        }
        return value;    
    }
}