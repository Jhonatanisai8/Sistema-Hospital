package com.jhonatan.sistemahospital.ClasesEstaticas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ValidarCamposRegistroAdmision {

    public static String validarCamposADmicion(JTable tblPacientes, JTable tblDcotores, JTextField txtFechaAdmision, JTextField txtFechaAlta, JTextArea txaDiagnostico) {
        int idPaciente[] = tblPacientes.getSelectedRows();
        if (idPaciente.length > 1) {
            return "ID Paciente: SOLO DEBE SELECIONAR UNA PERSONA.";
        }

        int idDocotor[] = tblDcotores.getSelectedRows();
        if (idDocotor.length > 1) {
            return "ID Doctor: SOLO DEBE SELECIONAR UNA Doctor.";
        }

        if (txtFechaAdmision.getText().isBlank()) {
            txtFechaAdmision.requestFocus();
            return "Fecha Admision.";
        }

        if (txtFechaAlta.getText().isBlank()) {
            txtFechaAlta.requestFocus();
            return "Fecha Alta.";
        }

        if (txaDiagnostico.getText().isBlank()) {
            txaDiagnostico.requestFocus();
            return "Diagnostico.";
        }

        return "";
    }

    public static java.util.Date obtenerFecha(String fechaIngresada) {
        java.util.Date fecha = null;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            fecha = formatoFecha.parse(fechaIngresada);
        } catch (ParseException e) {
            System.out.println("error al convertir fecha " + e.getMessage());
        }
        return fecha;
    }

}
