package Modelo;

import Interfaces.IToJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Articulo extends Material implements IToJSON {
    //atributos
    private String resumen;

    public Articulo(String titulo, String autor, int anioPublicacion, int cantEjemplares, boolean estaDisponible, String resumen) {
        super(titulo, autor, anioPublicacion, cantEjemplares, estaDisponible);
        this.resumen = resumen;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String toString() {
        return " Articulo {" +
                "Resumen: '" + resumen + '\'' +
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
            json.put("Resumen", resumen);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return json;
    }
}
