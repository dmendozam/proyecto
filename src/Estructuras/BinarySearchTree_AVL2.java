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
//NO PUEDEN HABER NODOS REPETIDOS

public class BinarySearchTree_AVL2<T> {
    public AVLTreeNode2String<T> root;
    public BinarySearchTree_AVL2(AVLTreeNode2String root) {
        this.root = root;
    }    
    public BinarySearchTree_AVL2() {
    }    
    public AVLTreeNode2String<T> contains(String identificadorbuscado){
        AVLTreeNode2String sentinela= new AVLTreeNode2String();
        
        sentinela=this.root;
        if(sentinela==null){
            return null;
        }
        boolean flag=false;
        while(flag==false){
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
    public void insertar(AVLTreeNode2String insertado){
        AVLTreeNode2String sentinela= root;
        if(sentinela==null){
            this.root=insertado;
        }
        else{
            boolean flag=false;
            while(flag==false){
                if(sentinela.identificador.compareTo(insertado.identificador)<0){
                    if(sentinela.right==null){
                        sentinela.right=insertado;
                        insertado.parent=sentinela;
                        flag=true;
                    }
                    else{
                        sentinela=sentinela.right;
                    }
                }
                if(sentinela.identificador.compareTo(insertado.identificador)>0){
                    if(sentinela.left==null){
                        sentinela.left=insertado;
                        insertado.parent=sentinela;
                        flag=true;
                    }
                    else{
                        sentinela=sentinela.left;
                    }
                }
            }
        }   
    }
    public AVLTreeNode2String eliminar(String identificadorEliminado){
        AVLTreeNode2String eliminando=contains(identificadorEliminado);
        if(eliminando==null){
            return null;
        }
        else{
            if(eliminando.right==null){
                if(eliminando==eliminando.parent.left){
                    eliminando.parent.left=eliminando.left;
                    
                }
                if(eliminando==eliminando.parent.right){
                    eliminando.parent.right=eliminando.left;
                    
                }
            }
            else{
                AVLTreeNode2String x=next(eliminando);
                if(eliminando==eliminando.parent.left){
                    eliminando.parent.left=x;
                    
                }
                if(eliminando==eliminando.parent.right){
                    eliminando.parent.right=x;
                    
                }
                
            }
            return eliminando;
        }
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
    
}
 

