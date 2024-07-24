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

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    


}
