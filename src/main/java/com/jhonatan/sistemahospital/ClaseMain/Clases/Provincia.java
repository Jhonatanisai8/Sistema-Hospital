package com.jhonatan.sistemahospital.ClaseMain.Clases;

public class Provincia {

    private char idProvincia;
    private String nombre;

    public Provincia() {
    }

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public Provincia(char idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }

}
