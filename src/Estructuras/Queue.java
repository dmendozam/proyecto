/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.LinkedList;

/**
 *
 * @author Santiago Mendoza
 */
public class Queue<T> {
    public LinkedList<T> lista= new LinkedList<T>();

    public Queue() {
    }
    
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    
    public T enqueue(T entrante){
        lista.pushBack(entrante);
        return entrante;
    }
    
    public void enqueue(Queue<T> queue2){
        lista.pushBack(queue2.lista);
    }
    
    public T dequeue(){
        T dequeue=lista.popFront();
        return dequeue;
    }
    public T front (){
        return lista.topFront();
    }
    public T rear (){
        return lista.topBack();
    }
}
