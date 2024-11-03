package Gestion;

import Interfaces.ITitulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Biblioteca <T extends ITitulo>{

    private Set<T> lista;

    public Biblioteca(){
        lista = new HashSet<>();
    }

    public String agregarElemento(T elemento){
       String mensaje = "";

        if(elemento != null){
            if(!lista.contains(elemento)){
                lista.add(elemento);
                mensaje = "El elemento " + elemento.toString() + " ha sido agregado con exito.";
            }
            else{
                mensaje = "El elemento " + elemento.toString() + " ya existe dentro de su lista";
            }
        }
        else{
            mensaje = "El elemento no puede ser nulo";
        }

        return mensaje;
    }

    public String eliminarElemento(T elemento){
        String mensaje = "";
        if(elemento != null){
            if(lista.contains(elemento)){
                lista.remove(elemento);
                mensaje = "El elemento " + elemento.toString() + " ha sido eliminado.";
            }
            else{
                mensaje = "El elemento " + elemento.toString() + " no pertenece a esta lista.";
            }
        }
        else{
            mensaje = "El elemento no puede ser nulo";
        }
        return mensaje;
    }

    public String buscarElemento(T elemento){
        String mensaje = "";
        if(elemento != null){
            if(lista.contains(elemento)){
                mensaje = elemento.toString();
            }
        }
        return mensaje;
    }

    public String buscarElementoPorNombre(String nombre){
        String mensaje = "";
        Iterator<T> iterador = lista.iterator();
        while(iterador.hasNext()){
            T elemento = iterador.next();
            if(elemento.getTitulo().equals(nombre)) {
                mensaje = elemento.toString();
            }
        }
        return mensaje;
    }


}
