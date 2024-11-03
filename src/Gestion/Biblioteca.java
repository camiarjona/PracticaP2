package Gestion;

import Excepciones.MaterialInexistente;
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
            try{
                verificarExistencia(elemento);
                lista.remove(elemento);
                mensaje = "Elemento eliminado con exito";
            }catch(MaterialInexistente e){
                mensaje = e.getMessage();
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
           try{
               verificarExistencia(elemento);
               lista.add(elemento);
           }catch(MaterialInexistente e){
               mensaje = e.getMessage();
           }
        }
        return mensaje;
    }

    public String buscarElementoPorNombre(String nombre){
        String mensaje = "";
        Iterator<T> iterador = lista.iterator();
        while(iterador.hasNext()){
            T elemento = iterador.next();
            if(elemento.getTitulo().equalsIgnoreCase(nombre)) {
                mensaje = elemento.toString();
            }
            else{
                mensaje = "No hay coincidencias.";
            }
        }
        return mensaje;
    }

    public String mostrarElementos(){
        StringBuilder sb = new StringBuilder();
        Iterator<T> iterador = lista.iterator();
        while(iterador.hasNext()){
            T elemento = iterador.next();
            sb.append(elemento.toString());
        }

        return sb.toString();
    }

    public void verificarExistencia(T material) throws MaterialInexistente{
        if(!lista.contains(material)){
            throw new MaterialInexistente("El elemento no se encuentra en la lista");
        }
    }


}
