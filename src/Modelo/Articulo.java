package Modelo;

import Interfaces.IToJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Articulo extends Material {
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

    public static Articulo traerDeJson(JSONObject json) {
        try{
            String titulo = json.getString("Titulo");
            String autor = json.getString("Autor");
            int anioPublicacion = json.getInt("AnioPublicacion");
            int cantEjemplares = json.getInt("CantEjemplares");
            boolean estaDisponible = json.getBoolean("EstaDisponible");
            String resumen = json.getString("Resumen");

            return new Articulo(titulo,autor,anioPublicacion, cantEjemplares, estaDisponible, resumen);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
