/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Estructuras.AVLTreeNode;
import Estructuras.BinarySearchTree_AVL2;
import Estructuras.LinkedList;
import Modelo.Usuario;
import Modelo.Vehiculo;
import java.util.ArrayList;
import Estructuras.*;

/**
 *
 * @author Santiago Mendoza
 */
public class AdministrarVehiculo {
    public LinkedList<Vehiculo> listaDeVehiculos;
    int sizeLista=0;
    int sizeArbol=0;
    public LinkedList<Vehiculo> vehiculosAlquilados;
    public BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeVehiculos;
    public BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeVehiculosAlquilados;
    public AdministrarVehiculo() {
        listaDeVehiculos = new LinkedList<>();
        vehiculosAlquilados= new LinkedList<>();
        arbolDeVehiculos= new BinarySearchTree_AVL2<>();
        arbolDeVehiculosAlquilados= new BinarySearchTree_AVL2<>();
        llenarVehiculosIniciales();
    }
    public AdministrarVehiculo(LinkedList<Vehiculo> listaDeVehiculos,LinkedList<Vehiculo> vehiculosAlquilados) {
        this.listaDeVehiculos = listaDeVehiculos;
        this.sizeLista = listaDeVehiculos.size();
        this.vehiculosAlquilados=vehiculosAlquilados;
        llenarVehiculosIniciales();
    }
    private void llenarVehiculosIniciales(){
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "ZZZ999",7));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "ZZZ998",5));
        agregarVehiculo(new Vehiculo(0, 0, "Toyota", "Fortuner", 2100, "ZZZ997",7));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Sail", 800, "ZZZ996",5));
        agregarVehiculo(new Vehiculo(0, 0, "Cheverolet", "Spark", 1200, "ZZZ995",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "m",7));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "t",5));
        //agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "f",5));
        //agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "s",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Fortuner", 2100, "a",7));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Cheverolet", "Sail", 800, "ZZZ996",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Cheverolet", "Spark", 1200, "ZZZ995",5));
        
       
    }
    public Vehiculo buscarVehiculo(Vehiculo v){ //Busqueda Binaria
    
    
    return v;
    }
    public void agregarVehiculo(Vehiculo v){
        //char letra = v.getReferencia().charAt(0);
        this.listaDeVehiculos.pushBack(v);
        
    }
    public void agregarVehiculoArbol(Vehiculo v){
        AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolReferencias=new AVLTreeNode2String();
        
        nodoArbolReferencias=arbolDeVehiculos.contains(v.getMarca());
        
        if(nodoArbolReferencias!=null){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolReferencias.key;
            AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas= arbolDeReferencias.contains(v.getReferencia());
            if(nodoArbolDePlacas!=null){
                BinarySearchTree_AVL2 arbolDePlacas=nodoArbolDePlacas.key;
                arbolDePlacas.insertar(new AVLTreeNode2String(v, v.getPlaca()));
                sizeArbol++;
            }
            else{
                BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(new AVLTreeNode2String(v,v.getPlaca()));
                arbolDeReferencias.insertar(new AVLTreeNode2String(nuevaReferencia,v.getReferencia()));
                sizeArbol++;
            }
        }
        else{
            BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(new AVLTreeNode2String(v,v.getPlaca()));
            
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> nuevaMarca= new BinarySearchTree_AVL2(new AVLTreeNode2String(nuevaReferencia, v.getReferencia()));
            
            arbolDeVehiculos.insertar(new AVLTreeNode2String(nuevaMarca, v.getMarca()));
            sizeArbol++;
        }
    }
    public void agregarVehiculoArbolAlquilados(Vehiculo v){
        AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolReferencias=new AVLTreeNode2String();
        
        nodoArbolReferencias=arbolDeVehiculosAlquilados.contains(v.getMarca());
        
        if(nodoArbolReferencias!=null){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolReferencias.key;
            AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas= arbolDeReferencias.contains(v.getReferencia());
            if(nodoArbolDePlacas!=null){
                BinarySearchTree_AVL2 arbolDePlacas=nodoArbolDePlacas.key;
                arbolDePlacas.insertar(new AVLTreeNode2String(v, v.getPlaca()));
                
            }
            else{
                BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(new AVLTreeNode2String(v,v.getPlaca()));
                arbolDeReferencias.insertar(new AVLTreeNode2String(nuevaReferencia,v.getReferencia()));
            }
        }
        else{
            BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(new AVLTreeNode2String(v,v.getPlaca()));
            
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> nuevaMarca= new BinarySearchTree_AVL2(new AVLTreeNode2String(nuevaReferencia, v.getReferencia()));
            
            arbolDeVehiculosAlquilados.insertar(new AVLTreeNode2String(nuevaMarca, v.getMarca()));
        }
    }    
    public AVLTreeNode2String<Vehiculo> buscarVehiculoArbol(String marca,String referencia){
        AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDeReferencias=arbolDeVehiculos.contains(marca);
        if(nodoArbolDeReferencias!=null){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolDeReferencias.key;
            if(arbolDeReferencias==null){
                return null;
            }
            else{
                AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas=arbolDeReferencias.contains(referencia);
                if(nodoArbolDePlacas!=null){
                    BinarySearchTree_AVL2<Vehiculo> arbolDePlacas=nodoArbolDePlacas.key;
            
                    if(arbolDePlacas!=null){
                        return arbolDePlacas.root;
                    }
                    else{
                        return null;
                    }
                }    
                else{
                    return null;
                }
            }
        
        }
        else{
            return null;
        }
    }
    public Vehiculo borrarVehiculoArbol(String marca, String referencia){
        AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDeReferencias=arbolDeVehiculos.contains(marca);
        if(nodoArbolDeReferencias!=null){
            
            //System.out.println("hola");
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolDeReferencias.key;
           //System.out.println(nodoArbolDeReferencias.identificador);
            if(arbolDeReferencias==null){
                
                return null;
            }
            else{
                AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas=arbolDeReferencias.contains(referencia);
                if(nodoArbolDePlacas!=null){
                    //System.out.println(nodoArbolDePlacas.identificador);
                    BinarySearchTree_AVL2<Vehiculo> arbolDePlacas=nodoArbolDePlacas.key;
            
                    if(arbolDePlacas!=null){
                        System.out.println("hola4");
                        AVLTreeNode2String nodoAEliminar=arbolDePlacas.root;
                        
                        //System.out.println(nodoAEliminar.identificador);
                        AVLTreeNode2String<Vehiculo> nodoEliminado =arbolDePlacas.eliminar(nodoAEliminar);
                        if(nodoEliminado!=null){
                            return nodoEliminado.key;
                        }
                        else{
                            return null;
                        }
                        
                    }
                    else{
                        return null;
                    }
                }    
                else{
                    return null;
                }
            }
        
        }
        else{
            return null;
        }
    }
    public void editarVehiculo(Vehiculo v){
        Vehiculo a_editar=buscarVehiculo(v);
    }
    public Vehiculo borrarVehiculo(Vehiculo v){
        return this.listaDeVehiculos.Eliminar(v);
    }
    public int  size(){
    return listaDeVehiculos.size();
    }
    public int sizeArbol(){
        return sizeArbol;
    }
}
