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
    private char idProvincia;
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

}
