package Modelo;

public class Articulo extends Material{
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
}
