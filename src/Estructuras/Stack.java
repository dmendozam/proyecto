/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Nodo;

/**
 *
 * @author Santiago Mendoza
 * @param <T>
 */
public class Stack<T> {
    Nodo<T> top;
    private int size;
    
    public Stack(){
        this.top=null;
        this.size=0;
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(this.size==0){
            return true;
        }else{
            return false;
        }
    }

    public void push(T key) {
        Nodo<T> nodo = new Nodo<>(key, this.top);
        this.top=nodo;
        this.size++;
    }
    
    public void push (Stack<T> stack){
        while(!stack.isEmpty()){
            this.push(stack.pop());
        }
    }

    public T pop() {
        T temp;
        if(isEmpty()){
            System.out.println("Pila vacía");
            return null;
        }
        temp=this.top.key;
        this.top=this.top.next;
        size--;
        return temp;
        
        
    }

    public T top() {
        if(isEmpty()){
            System.out.println("Pila vacía");
            return null;
        }
        return this.top.key;
    }
}
