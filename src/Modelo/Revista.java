package Modelo;

import Excepciones.SuscripcionInactiva;
import Interfaces.IDevolver;
import Interfaces.IPrestar;
import Interfaces.IToJSON;
import org.json.JSONException;
import org.json.JSONObject;

public class Revista extends Material implements IDevolver, IPrestar, IToJSON {
    //atributos
    private int numEdicion;
    private boolean estaSuscripta;

    public Revista(String titulo, String autor, int anioPublicacion, int cantEjemplares, boolean estaDisponible, int numEdicion, boolean estaSuscripta) {
        super(titulo, autor, anioPublicacion, cantEjemplares, estaDisponible);
        this.numEdicion = numEdicion;
        this.estaSuscripta = estaSuscripta;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    public boolean getEstaSuscripta() {
        return estaSuscripta;
    }

    public void setEstaSuscripta(boolean estaSuscripta) {
        this.estaSuscripta = estaSuscripta;
    }

    @Override
    public String devolver() {

        setCantEjemplares(cantEjemplares + 1);

        if(!estaDisponible){
            setEstaDisponible(true);
        }

        return "Revista devuelta con exito. Cantidad de ejemplares disponibles: " + getCantEjemplares();
    }

    @Override
    public String prestar() {
        String mensaje = "";

        try{
            verificarSuscripcion();
            if(cantEjemplares == 0){
                mensaje = "No hay ejemplares disponibles para el prestamo";
                setEstaDisponible(false);
            }
            else {
                setCantEjemplares(cantEjemplares - 1);
                mensaje = "Prestamo exitoso. Quedan " + cantEjemplares + " ejemplares disponibles";
                if (cantEjemplares == 0) {
                    setEstaDisponible(false);
                }
            }
        }catch (SuscripcionInactiva e){
                mensaje = e.getMessage();
            }

        return mensaje;
    }

    public void verificarSuscripcion() throws SuscripcionInactiva {
        if(!estaSuscripta){
            throw new SuscripcionInactiva("Suscripcion inactiva. Modelo.Revista no disponible para prestamo.");
        }
    }

    @Override
    public String toString() {
        return " Revista {" +
                "NumEdicion: " + numEdicion +
                ", EstaSuscripta: " + estaSuscripta +
                "," + super.toString();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try{
            json.put("Titulo", titulo);
            json.put("Autor", autor);
            json.put("AnioPublicacion", anioPublicacion);
            json.put("CantEjemplares", cantEjemplares);
            json.put("EstaDisponible", estaDisponible);
            json.put("NumEdicion", numEdicion);
            json.put("EstaSuscripta", estaSuscripta);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return json;
    }
}
