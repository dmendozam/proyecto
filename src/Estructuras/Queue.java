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
    LinkedList<T> lista= new LinkedList<T>();

    public Queue() {
    }
    
    
    public T enqueue(T entrante){
        lista.pushBack(entrante);
        return entrante;
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
