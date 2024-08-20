package com.jhonatan.sistemahospital.ClaseMain.Clases;

public class Provincia {

    private int idProvincia;
    private String nombre;

    public Provincia() {
    }

    public Provincia(char idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Provincia(char idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
