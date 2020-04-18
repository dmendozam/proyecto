/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Santiago Mendoza
 */
public class LinkedList<T> {
    Nodo<T> top;
    private int size;

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return this.top == null;
    }
    
    public void push(T key) {
        Nodo<T> nodo = new Nodo<>(key, this.top); 
        this.top = nodo; 
        this.size++; 
    }
    
    public T pop() {
        T temp;
        if(isEmpty()) {
            return null;
        } else {
            temp = top.key;
            top = top.next; 
            size--;
            return temp;
        }
    }

    public T top() {
        if(isEmpty()) {
            return null;
        } else {
            return top.key;
        }
    }
}
