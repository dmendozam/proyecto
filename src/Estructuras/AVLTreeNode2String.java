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
public class AVLTreeNode2String<T>{
    
    public T key;
    public String identificador;
    public int height;
    public AVLTreeNode2String left;
    public AVLTreeNode2String right;
    public AVLTreeNode2String parent;
   
    
    public AVLTreeNode2String(T key,AVLTreeNode2String parent,String identificador, AVLTreeNode2String left, AVLTreeNode2String right){
        this.key = key;
        this.identificador=identificador;
        this.left = left;
        this.right = right;
        this.height = 0;
        this.parent=parent;
    }
    
    public AVLTreeNode2String(T key,String identificador, int height){
        this.key = key;
        this.identificador=identificador;
        this.left = null;
        this.right = null;
        this.height = height;
        this.parent=null;
    }
    
    public AVLTreeNode2String(T key,String identificador){
        this.key = key;
        this.identificador=identificador;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.parent=null;
    }
    
    public AVLTreeNode2String(){
        this.key = null;
        this.identificador=null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.parent= null;
    }
}
