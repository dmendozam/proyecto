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
    
    T enqueue(T entrante){
        lista.pushBack(entrante);
        return entrante;
    }
    T dequeue(){
        T dequeue=lista.popFront();
        return dequeue;
    }
    T front (){
        return lista.topFront();
    }
    T rear (){
        return lista.topBack();
    }
}
