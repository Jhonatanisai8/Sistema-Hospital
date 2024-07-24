package com.jhonatan.sistemahospital.ClaseMain.Clases;

public class Doctor {

    // atributos
    private int idDoctor;
    private String nombre;
    private String apellido;
    private String especialidad;

    // coctructores
    public Doctor() {
    }

    // nos ayuda a eliminar
    public Doctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    // nos ayuda modificar
    public Doctor(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    // nos ayuda a eliminar
    public Doctor(int idDoctor, String nombre, String apellido, String especialidad) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    
}
