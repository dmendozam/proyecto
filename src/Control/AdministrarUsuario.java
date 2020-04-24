/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Estructuras.LinkedList;
import Modelo.Usuario;
import java.util.ArrayList;
import Modelo.Vehiculo;

/**
 *
 * @author Santiago Mendoza
 */
public class AdministrarUsuario {
    private ArrayList<Usuario> listaDeUsuarios;

    public AdministrarUsuario() {
        listaDeUsuarios = new ArrayList();
        llenarUsuariosIniciales();
    }

    public AdministrarUsuario(ArrayList<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
        llenarUsuariosIniciales();
    }
    
    private void llenarUsuariosIniciales(){
        listaDeUsuarios.add(new Usuario("Santiago Mendoza", "dmendozam", "1234", new LinkedList<Vehiculo>()));
        listaDeUsuarios.add(new Usuario("Camilo Pineda", "dosoriof", "0000", new LinkedList<Vehiculo>()));
        listaDeUsuarios.add(new Usuario("Diego Osorio", "capinedac", "1111", new LinkedList<Vehiculo>()));
        
       
    }
    public Usuario buscarUsuario(String usuarioIngresado){
    Usuario u = new Usuario();
    u =null;
    for(Usuario  i: listaDeUsuarios){
        if(i.getUsuario().equals(usuarioIngresado)){
            
            u=i;
            
            }   
    }
    return u;
    }
    public void agregarUsuario(Usuario u){
        listaDeUsuarios.add(u);
    }
    
    public void editarUsuario(Usuario u){
        listaDeUsuarios.set(listaDeUsuarios.indexOf(u), u);
    }
     
    public void borrarUsuario(Usuario u){
        listaDeUsuarios.remove(u);
    }
    public void cambiarContrasena(Usuario usuarioACambiarContrasena,String contrasenaNueva){
        usuarioACambiarContrasena.setClave(contrasenaNueva);
        
    
    }
}