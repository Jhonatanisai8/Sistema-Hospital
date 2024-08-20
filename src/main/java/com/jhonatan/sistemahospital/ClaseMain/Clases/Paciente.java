package com.jhonatan.sistemahospital.ClaseMain.Clases;

import java.util.Date;

public class Paciente {

    // atributos
    private int idPaciente;
    private String nombre;
    private String apellido;
    private char genero;
    private Date fechaNacimiento;
    private String ciudad;
    private int idProvincia;
    private String alergias;
    private double peso;
    private double altura;

    public Paciente() {
    }

    // constructor que nos permitira eliminar
    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    // constructor que nos permitira modificar
    public Paciente(String nombre, String apellido, char genero, Date fechaNacimiento, String ciudad, char idProvincia,
            String alergias, double peso, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.idProvincia = idProvincia;
        this.alergias = alergias;
        this.peso = peso;
        this.altura = altura;
    }

    // constructor que nos permitira eliminar
    public Paciente(int idPaciente, String nombre, String apellido, char genero, Date fechaNacimiento, String ciudad,
            char idProvincia, String alergias, double peso, double altura) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.idProvincia = idProvincia;
        this.alergias = alergias;
        this.peso = peso;
        this.altura = altura;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
