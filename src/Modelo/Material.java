package Modelo;

import Interfaces.ITitulo;

import java.util.Objects;

public class Material implements ITitulo {
    //atributos
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected int cantEjemplares;
    protected boolean estaDisponible;

    public Material(String titulo, String autor, int anioPublicacion, int cantEjemplares, boolean estaDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantEjemplares = cantEjemplares;
        this.estaDisponible = estaDisponible;
    }

    public Material() {
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    public boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(titulo, material.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    @Override
    public String toString() {
        return " " +
                "Titulo: '" + titulo + '\'' +
                ", Autor: '" + autor + '\'' +
                ", AnioPublicacion: " + anioPublicacion +
                ", CantEjemplares: " + cantEjemplares +
                ", EstaDisponible: " + estaDisponible +
                '}';
    }
}
