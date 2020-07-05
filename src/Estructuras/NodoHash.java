/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Santiago Mendoza
 */
public class NodoHash <T> {
    public T key;
    public int size;
    public String identificador;

    public NodoHash(T key,String ide) {
        this.key = key;
        this.size=0;
        this.identificador=ide;
    }
    
}
