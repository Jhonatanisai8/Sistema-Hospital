package com.jhonatan.sistemahospital.ClaseMain.Clases;

import java.util.Date;

public class Admision {

    private int idPaciente;
    private Date fechaAdmision;
    private Date fechaAlta;
    private String diagnostico;
    private int idDoctor;

    public Admision() {
    }

    public Admision(Date fechaAdmision, Date fechaAlta, String diagnostico, int idDoctor) {
        this.fechaAdmision = fechaAdmision;
        this.fechaAlta = fechaAlta;
        this.diagnostico = diagnostico;
        this.idDoctor = idDoctor;
    }

    public Admision(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Admision(int idPaciente, Date fechaAdmision, Date fechaAlta, String diagnostico, int idDoctor) {
        this.idPaciente = idPaciente;

    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaAdmision() {
        return fechaAdmision;
    }

    public void setFechaAdmision(Date fechaAdmision) {
        this.fechaAdmision = fechaAdmision;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

}
