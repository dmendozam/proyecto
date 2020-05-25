/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Universidad
 */
public class AVLTreeNode<T> {
    public T key;
    public int height;
    public AVLTreeNode left;
    public AVLTreeNode right;
    
    public AVLTreeNode(T key, AVLTreeNode left, AVLTreeNode right){
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
    
    public AVLTreeNode(T key, int height){
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = height;
    }
    
    public AVLTreeNode(T key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
    
    public AVLTreeNode(){
        this.key = null;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}
