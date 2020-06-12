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
    public BinarySearchTree_AVL2<Vehiculo> arbolDeVehiculosAlquilados;
    public BinarySearchTree_AVL2<Vehiculo> arbolDeVehiculosPlacas;
    
    
    
    public AdministrarVehiculo() {
        listaDeVehiculos = new LinkedList<>();
        vehiculosAlquilados= new LinkedList<>();
        arbolDeVehiculos= new BinarySearchTree_AVL2<>();
        arbolDeVehiculosAlquilados= new BinarySearchTree_AVL2<>();
        arbolDeVehiculosPlacas= new BinarySearchTree_AVL2<>();
        
        
        llenarVehiculosIniciales();
    }
    public AdministrarVehiculo(LinkedList<Vehiculo> listaDeVehiculos,LinkedList<Vehiculo> vehiculosAlquilados, BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeVehiculos,BinarySearchTree_AVL2<Vehiculo> arbolDeVehiculosAlquilados) {
        this.listaDeVehiculos = listaDeVehiculos;
        this.sizeLista = listaDeVehiculos.size();
        this.vehiculosAlquilados=vehiculosAlquilados;
        this.arbolDeVehiculos=arbolDeVehiculos;
        this.arbolDeVehiculosAlquilados=arbolDeVehiculosAlquilados;
        llenarVehiculosIniciales();
    }
    private void llenarVehiculosIniciales(){
        
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "m",7));
        
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "t",5));
        //System.out.println("hola");
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "f",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Prado", 4500, "s",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Toyota", "Fortuner", 2100, "a",7));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Cheverolet", "Sail", 800, "ZZZ996",5));
        agregarVehiculoArbol(new Vehiculo(0, 0, "Cheverolet", "Spark", 1200, "ZZZ995",5));
        
        
        //System.out.println(hola.key.getMarca()+hola.key.getReferencia()+hola.key.getPlaca());
        //System.out.println(hola2);
        
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
                //nodos equivalentes (POR AHORA SOLO PLACA)
                AVLTreeNode2String insertadoArbol=new AVLTreeNode2String(v, v.getPlaca());
                AVLTreeNode2String insertadoPlaca =new AVLTreeNode2String(v,v.getPlaca());
                insertadoArbol.listaEquivalentes.pushFront(insertadoPlaca);
                insertadoPlaca.listaEquivalentes.pushFront(insertadoArbol);
                
                arbolDePlacas.insertarAVL(insertadoArbol);
                arbolDeVehiculosPlacas.insertarAVL(insertadoPlaca);
                sizeArbol++;
                
            }
            else{
                AVLTreeNode2String insertadoArbol=new AVLTreeNode2String(v, v.getPlaca());
                AVLTreeNode2String insertadoPlaca =new AVLTreeNode2String(v,v.getPlaca());
                insertadoArbol.listaEquivalentes.pushFront(insertadoPlaca);
                insertadoPlaca.listaEquivalentes.pushFront(insertadoArbol);
                BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(insertadoArbol);
                
                arbolDeReferencias.insertarAVL(new AVLTreeNode2String(nuevaReferencia,v.getReferencia()));
                arbolDeVehiculosPlacas.insertarAVL(insertadoPlaca);
                sizeArbol++;
            }
        }
        else{
            AVLTreeNode2String insertadoArbol=new AVLTreeNode2String(v, v.getPlaca());
            AVLTreeNode2String insertadoPlaca =new AVLTreeNode2String(v,v.getPlaca());
            insertadoArbol.listaEquivalentes.pushFront(insertadoPlaca);
            insertadoPlaca.listaEquivalentes.pushFront(insertadoArbol);
            
            BinarySearchTree_AVL2<Vehiculo>nuevaReferencia=new BinarySearchTree_AVL2(insertadoArbol);
            
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> nuevaMarca= new BinarySearchTree_AVL2(new AVLTreeNode2String(nuevaReferencia, v.getReferencia()));
            //System.out.println("hola2");
            arbolDeVehiculos.insertarAVL(new AVLTreeNode2String(nuevaMarca, v.getMarca()));
            //System.out.println("hola3");
            
            arbolDeVehiculosPlacas.insertarAVL(insertadoPlaca);
            
            sizeArbol++;
        }
    }
    public void agregarVehiculoArbolAlquilados(Vehiculo v){
        AVLTreeNode2String<Vehiculo> aIngresar= new AVLTreeNode2String<>(v, v.getPlaca());
        arbolDeVehiculosAlquilados.insertarAVL(aIngresar);
    }    
    
    public void agregarVehiculoArbolPlacas(Vehiculo v){
        arbolDeVehiculosPlacas.insertarAVL(new AVLTreeNode2String(v, v.getPlaca()));
    }
    
    public Stack<Vehiculo> buscarVehiculoArbolPlacas (String placa){
        AVLTreeNode2String<Vehiculo> coincide = arbolDeVehiculosPlacas.contains(placa);
        Stack<Vehiculo> vehiculos = new Stack<>();
        if (coincide != null){
            vehiculos.push(coincide.key);
        }
        return vehiculos;
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
    
    public Stack<Vehiculo> buscarVehiculoArbolMarca (String marca){
        Stack<Vehiculo> busqueda= new Stack<>();
        AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDeReferencias=arbolDeVehiculos.contains(marca);
        if (nodoArbolDeReferencias!=null){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolDeReferencias.key;
            Stack<BinarySearchTree_AVL2> pilaDeReferencias= arbolDeReferencias.postOrder();
            while(!pilaDeReferencias.isEmpty()){
                BinarySearchTree_AVL2<Vehiculo> arbolDePlacas = pilaDeReferencias.pop();
                busqueda.push(arbolDePlacas.postOrder());
            }
        }
        return busqueda;
    }
    
    public Stack<Vehiculo> buscarVehiculoArbolModelo (String modelo){
        Stack<Vehiculo> busqueda = new Stack<>();
        Stack<BinarySearchTree_AVL2> pilaDeMarcas = arbolDeVehiculos.postOrder();
        while(!pilaDeMarcas.isEmpty()){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> aux = pilaDeMarcas.pop();
            AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDeReferencias = aux.contains(modelo);
            if (nodoArbolDeReferencias!=null){
                BinarySearchTree_AVL2<Vehiculo> arbolDePlacas = nodoArbolDeReferencias.key;
                busqueda.push(arbolDePlacas.postOrder());
                return busqueda;
            }
        }
        
        return busqueda;
    }
    
    public Stack<Vehiculo> buscarVehiculoArbolPlaca2 (String placa){
        Stack<Vehiculo> busqueda = new Stack<>();
        Stack<BinarySearchTree_AVL2> pilaDeMarcas = arbolDeVehiculos.postOrder();
        while(!pilaDeMarcas.isEmpty()){
            BinarySearchTree_AVL2<BinarySearchTree_AVL2> aux = pilaDeMarcas.pop();
            Stack<BinarySearchTree_AVL2> pilaDeModelos = aux.postOrder();
            while(!pilaDeModelos.isEmpty()){
                BinarySearchTree_AVL2<Vehiculo> aux2 = pilaDeModelos.pop();
                AVLTreeNode2String<Vehiculo> nodoDePlaca = aux2.contains(placa);
                if(nodoDePlaca!=null){
                    busqueda.push(nodoDePlaca.key);
                    return busqueda;
                }
            }
            
        }
        return busqueda;
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
                        //System.out.println("hola4");
                        AVLTreeNode2String nodoAEliminar=arbolDePlacas.root;
                        
                        //System.out.println(nodoAEliminar.identificador);
                        AVLTreeNode2String<Vehiculo> nodoEliminado =arbolDePlacas.eliminarAVL(nodoAEliminar);
                        //A CONTINUACIONELIMINAR EQUIVALENTE
                        AVLTreeNode2String<Vehiculo> nodoEliminadoPlacas;
                        if(nodoEliminado!=null)nodoEliminadoPlacas=arbolDeVehiculosPlacas.eliminarAVL(nodoEliminado.listaEquivalentes.top.key);
                        
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
    
    public Vehiculo borrarVehiculoArbolConPlaca(String marca, String referencia, String placa){
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
                        //System.out.println("hola4");
                        AVLTreeNode2String nodoAEliminar=arbolDePlacas.contains(placa);
                        if(nodoAEliminar!=null){
                            //System.out.println(nodoAEliminar.identificador);
                            AVLTreeNode2String<Vehiculo> nodoEliminado =arbolDePlacas.eliminarAVL(nodoAEliminar);
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
                else{
                    return null;
                }
            }
        
        }
        else{
            return null;
        }
    }
    
    public Vehiculo borrarVehiculoArbolAlquilados(String placa){
        
        AVLTreeNode2String<Vehiculo> nodoEliminado =arbolDeVehiculosAlquilados.contains(placa);
        arbolDeVehiculosAlquilados.eliminarAVL(nodoEliminado);
        
        if(nodoEliminado!=null){
            System.out.println("gg");
            Vehiculo saliente=nodoEliminado.key;
            return saliente;
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
