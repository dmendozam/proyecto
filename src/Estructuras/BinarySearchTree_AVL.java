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
public class BinarySearchTree_AVL<T> {
    public AVLTreeNode<T> root;

    public BinarySearchTree_AVL(AVLTreeNode<T> root) {
        this.root = root;
    }
    
    public BinarySearchTree_AVL() {
    }
    
    public int height(){
        return height(root);
    }
        
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void makeEmpty(){
        root = null;
    }
    
    public void insert(T x){
        root = insert(x,root);        
    }
    
    public void remove( T x){
        root = remove(x, root);
    }
    
    public T findMin(){
        if(isEmpty()){
            //******** excepcion
            //throw new IllegalArgumentException("Arbol vacio");
        }return findMin(root).key;
    }
    
    public T findMax(){
        if(isEmpty()){
            //******** excepcion
            //throw new IllegalArgumentException("Arbol vacio");
        }return findMax(root).key;
    }
    
    public boolean contains(T x){
        return contains(x, root);
    }
    
    public AVLTreeNode<T> insert( T x, AVLTreeNode<T> nodo){
        if(nodo == null){
            return new AVLTreeNode<T> (x, null, null);
        }else{
            int comp = 0;
            //int comp = x.compareTo(nodo.key);  
            //funcion para comparar entre carros, definir mayor o menor en base a que. Si x es mayor da positivo
            if(comp < 0){
                nodo.left = insert(x,nodo.left);
                if(height(nodo.left) - height(nodo.right) == 2){
                    int comp2 = 1;
                    //int comp2 = x.compareTo(nodo.left.key);
                    if(comp2 < 0){
                        nodo = rotationLeft(nodo);
                    }else{
                        nodo = rotationDoubleLeft(nodo);
                    }
                }
            }if(comp > 0){
                nodo.right = insert(x,nodo.right);
                if(height(nodo.right) - height(nodo.left) == 2){
                    int comp2 = 1;
                    //int comp2 = x.compareTo(nodo.right.key);
                    if(comp2 > 0){
                        nodo = rotationRight(nodo);
                    }else{
                        nodo = rotationDoubleRight(nodo);
                    }
                }
            }else{
            }
            return nodo;
        }
    }
    
    public AVLTreeNode<T> remove( T x, AVLTreeNode<T> nodo ){
        if(nodo == null){
            return nodo;
        }
        int comp = 0;
        //int comp = x.compareTo(nodo.key);
        if(comp < 0){
            nodo.left = remove(x,nodo.left);
        }else if(comp > 0){
            nodo.right = remove(x,nodo.right);
        }else if(nodo.left != null && nodo.right != null){ //tiene 2 hijos
            nodo.key = (T) findMin(nodo.right).key; //cast
            nodo.right = remove(nodo.key, nodo.right);
        }else{
            nodo =  ( nodo.left != null ) ? nodo.left : nodo.right;  //********* creo que retorna el nodo, si left no es null, retorna primera opcion left, si lo es, retorna segunda right
            /*
            if(nodo.left != null){
                nodo = nodo.left;
            }else{
                nodo = nodo.right;
            }
            creo que esto es lo que hace
            */
        }
        return nodo;
    }
    
    public AVLTreeNode<T> findMin( AVLTreeNode<T> nodo ){
        if(nodo == null){
            return null;
        }else if(nodo.left == null){
            return nodo;
        }
        return findMin(nodo.left);
    }
    
    public AVLTreeNode<T> findMax( AVLTreeNode<T> nodo ){
        if(nodo == null){
            return null;
        }else if(nodo.right == null){
            return nodo;
        }
        return findMin(nodo.right);
    }
    
    public boolean contains( T x, AVLTreeNode<T> nodo ){
        if(nodo == null){
            return false;
        }
        int comp = 0;
        //int comp = x.compareTo(nodo.key);
        if(comp < 0){
            return contains(x,nodo.left);
        }else if(comp > 0){
            return contains(x,nodo.right);
        }else{
            return true;
        }
    }
    
    public void printTreePreOrder( AVLTreeNode<T> nodo ){
        
    }
    
    // demas metodos de recorrido
    
    public int height(AVLTreeNode nodo){
        if(nodo == null){
            return 0;
        }else{
            return nodo.height;
        }
    }
    
    public AVLTreeNode<T> rotationLeft(AVLTreeNode nodo){
        AVLTreeNode aux = nodo.left;
        nodo.left = aux.right;
        aux.right = nodo;
        if(height(nodo.left)>height(nodo.right)){
            nodo.height = height(nodo.left)+1;
        }else{
            nodo.height = height(nodo.right)+1;
        }
        if(height(aux.left)>nodo.height){
            aux.height = height(aux.left)+1;
        }else{
            aux.height = nodo.height+1;
        }
        return aux;
    }
    
    public AVLTreeNode<T> rotationRight(AVLTreeNode nodo){
        AVLTreeNode aux = nodo.right;
        nodo.right = aux.left;
        aux.left = nodo;
        if(height(nodo.left)>height(nodo.left)){
            nodo.height = height(nodo.left)+1;
        }else{
            nodo.height = height(nodo.right)+1;
        }
        if(height(aux.right)>nodo.height){
            aux.height = height(aux.right)+1;
        }else{
            aux.height = nodo.height+1;
        }
        return aux;
    }
    
    public AVLTreeNode<T> rotationDoubleLeft(AVLTreeNode nodo){
        nodo.left = rotationRight(nodo.left);
        return rotationLeft(nodo);
    }
    
    public AVLTreeNode<T> rotationDoubleRight(AVLTreeNode nodo){
        nodo.left = rotationLeft(nodo.right);
        return rotationRight(nodo);
    }
}
