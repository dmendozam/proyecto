/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import static java.lang.Integer.max;

/**
 *
 * @author Universidad
 */
//NO PUEDEN HABER NODOS REPETIDOS
//OPERACIONES DENTRO DE UN SOLO ARBOL
public class BinarySearchTree_AVL2<T> {
    public AVLTreeNode2String<T> root;
    public int size;
    public BinarySearchTree_AVL2(AVLTreeNode2String root) {
        this.root = root;
    }    
    public BinarySearchTree_AVL2() {
    }
    public int height(AVLTreeNode2String nodo){
        if(nodo==null){
            return -1;
        }
        else{
            return nodo.height;
        }
    }
    public AVLTreeNode2String<T> contains(String identificadorbuscado){
        AVLTreeNode2String sentinela= new AVLTreeNode2String();
        
        sentinela=this.root;
        if(sentinela==null){
            //System.out.println("hoy");
            return null;
        }
        boolean flag=false;
        while(flag==false){
            //System.out.println(sentinela.identificador);
            if(sentinela.identificador.compareTo(identificadorbuscado)==0){
                flag=true;
                return sentinela;
            }
            else if(sentinela.identificador.compareTo(identificadorbuscado)<0){
                if (sentinela.right==null){
                    return null;
                }
                else{
                    sentinela=sentinela.right;
                }
            }
            else if(sentinela.identificador.compareTo(identificadorbuscado)>0){
                if(sentinela.left==null){
                    return null;
                }
                else{
                    sentinela=sentinela.left;
                }
            }
        }
        return null;    
    }   
    public AVLTreeNode2String insertar(AVLTreeNode2String insertado){
        AVLTreeNode2String sentinela= root;
        if(sentinela==null){
            this.root=insertado;
            size++;
            return root;
            
            //System.out.println("hoy2");
        }
        else{
            boolean flag=false;
            while(flag==false){
                if(sentinela.identificador.compareTo(insertado.identificador)<0){
                    if(sentinela.right==null){
                        sentinela.right=insertado;
                        insertado.parent=sentinela;
                        size++;
                        
                        flag=true;
                        
                    }
                    else{
                        sentinela=sentinela.right;
                    }
                }
                else if(sentinela.identificador.compareTo(insertado.identificador)>0){
                    if(sentinela.left==null){
                        sentinela.left=insertado;
                        insertado.parent=sentinela;
                        size++;
                        
                        flag=true;
                        
                    }
                    else{
                        sentinela=sentinela.left;
                    }
                }
                else{
                    return null;
                }
                
                
            }
            return insertado;
        }   
    }
    public void insertarAVL(AVLTreeNode2String nodo){
        AVLTreeNode2String insertado =insertar(nodo);
        System.out.println(insertado);
        rebalance(insertado);
        
    }
    public AVLTreeNode2String eliminar(AVLTreeNode2String eliminando){
        
        if(eliminando==null){

            return null;
        }
        else{
            //System.out.println("hola7");
            System.out.println("root"+eliminando);
            System.out.println("derecha root"+eliminando.right);
            System.out.println("izquierda root"+eliminando.left);
            if(eliminando.right==null){
                //System.out.println("hola8");
                    if(eliminando==root){
                        root=eliminando.left;
                        size--;
                        if(eliminando.left!=null)eliminando.left.parent=null;
                    }
                    else{
                        if(eliminando==eliminando.parent.left){
                            if(eliminando.left!=null)eliminando.left.parent=eliminando.parent;
                            eliminando.parent.left=eliminando.left;
                            size--;
                   
                        }
                        else if(eliminando==eliminando.parent.right){
                            if(eliminando.left!=null)eliminando.left.parent=eliminando.parent;
                            eliminando.parent.right=eliminando.left;
                            size--; 
                    
                        }
                    }   
            }
            else{ //RIGHT DIFERENTE DE NULL
                AVLTreeNode2String x=next(eliminando);
                //System.out.println(eliminando);
                //System.out.println(x);
                //System.out.println(x.right);
                //System.out.println(x.parent);
                // promote x.right
                if(x.parent.left==x){
                    if(x.right!=null)x.right.parent=x.parent;
                    x.parent.left=x.right;
                }
                if(x.parent.right==x){
                    if(x.right!=null)x.right.parent=x.parent;
                    x.parent.right=x.right;
                }
                //System.out.println(eliminando.right);
                //REPLACE ELIMINANDO BY X
                if(eliminando==root){
                    x.right=eliminando.right;
                    x.left=eliminando.left;
                    
                    if(x.right!=null)x.right.parent=x;
                    if(x.left!=null)x.left.parent=x;
                    x.parent=null;
                    root=x;
                }
                else{
                    x.parent=eliminando.parent;
                    if(eliminando.parent.right==eliminando){
                        eliminando.parent.right=x;
                    }
                    if(eliminando.parent.left==eliminando){
                        eliminando.parent.left=x;
                    }
                    
                    x.right=eliminando.right;
                    x.left=eliminando.left;
                    if(x.right!=null)x.right.parent=x;
                    if(x.left!=null)x.left.parent=x;
                }
                size--;
                
                
                
                
                
                
            }
            return eliminando;
        }
    }
    public AVLTreeNode2String eliminarAVL (AVLTreeNode2String eliminando){
        AVLTreeNode2String eliminado=eliminar(eliminando);
        if(eliminando!=null){AVLTreeNode2String parent=eliminando.parent;
            if(parent!=null)rebalance(parent);
        }
        return eliminado;
    }
    private AVLTreeNode2String next(AVLTreeNode2String n){
        if(n.right!=null){
            return leftDescendent(n.right);
        }
        else{
            return rightAncestor(n);
        }
    }
    private AVLTreeNode2String leftDescendent(AVLTreeNode2String n){
        if(n.left==null){
            
            return n;
        }
        else{
            return leftDescendent(n.left);
        }
    }
    private AVLTreeNode2String rightAncestor(AVLTreeNode2String n){
        if(n.identificador.compareTo(n.parent.identificador)>0){
            return n.parent;
        }
        else{
            return rightAncestor(n.parent);
        }
    }
    
    public Stack<T> postOrder(AVLTreeNode2String<T> nodo){
        Stack<T> salida = new Stack<>();
        if(nodo.left!=null){
            salida.push(postOrder(nodo.left));
        }
        if(nodo.right!=null){
            salida.push(postOrder(nodo.right));
        }
        salida.push(nodo.key);
        return salida;
    }
    public Stack<T> postOrder(){
        return postOrder(this.root);
    }
    public void rebalance(AVLTreeNode2String nodo){
        AVLTreeNode2String parent=null;
        if(nodo!=null){
            parent=nodo.parent;
        
        
        
        if(height(nodo.left)>height(nodo.right)+1){
            //rebalance right
            rebalanceRight(nodo);
        }
        if(height(nodo.right)>height(nodo.left)+1){
            //rebalance left
            rebalanceLeft(nodo);
            
        }
            
        
        
        //adjust height
        adjustHeight(nodo);
        if(parent!=null){
            rebalance(parent);
        }
        }
    }
    public void adjustHeight(AVLTreeNode2String nodo){
        
        nodo.height=1+max(height(nodo.left),height(nodo.right));
        
        
    }
    public void rebalanceRight(AVLTreeNode2String nodo){
        AVLTreeNode2String izquierdo=nodo.left;
        
        if(height(izquierdo.right)>height(izquierdo.left)){
            rotationLeft(izquierdo);
        }
        rotationRight(nodo);
    }
    public void rebalanceLeft(AVLTreeNode2String nodo){
        AVLTreeNode2String derecho=nodo.right;
        
        if(height(derecho.left)>height(derecho.right)){
            rotationRight(derecho);
        }
        rotationLeft(nodo);
    }
    public void rotationRight(AVLTreeNode2String nodo){
        AVLTreeNode2String aux = nodo.left;
        nodo.left = aux.right;
        aux.right = nodo;
        adjustHeight(nodo);
        adjustHeight(aux);
        
    }
    public void rotationLeft(AVLTreeNode2String nodo){
        AVLTreeNode2String aux = nodo.right;
        nodo.right = aux.left;
        aux.left = nodo;
        adjustHeight(nodo);
        adjustHeight(aux);
    }    
    
}
    

