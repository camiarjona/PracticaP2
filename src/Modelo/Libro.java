package Modelo;

import Interfaces.IDevolver;
import Interfaces.IPrestar;

public class Libro extends Material implements IDevolver, IPrestar {
    //atributos
    private int numPaginas;

    public Libro(String titulo, String autor, int anioPublicacion, int cantEjemplares, boolean estaDisponible, int numPaginas) {
        super(titulo, autor, anioPublicacion, cantEjemplares, estaDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String devolver() {

        setCantEjemplares(cantEjemplares + 1);

        if(!estaDisponible){
            setEstaDisponible(true);
        }

        return "Libro devuelto con exito. Cantidad de ejemplares disponibles: " + getCantEjemplares();
    }

    @Override
    public String prestar() {
        String mensaje = "";
        if(cantEjemplares == 0){
            mensaje = "No hay ejemplares disponibles para el prestamo";
            setEstaDisponible(false);
        }
        else{
            setCantEjemplares(cantEjemplares-1);
            mensaje = "Prestamo exitoso. Quedan " + cantEjemplares + " ejemplares disponibles";
            if(cantEjemplares == 0){
                setEstaDisponible(false);
            }
        }
        return mensaje;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "numPaginas=" + numPaginas +
                "} " + super.toString();
    }
}
