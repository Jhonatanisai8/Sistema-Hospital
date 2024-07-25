package com.jhonatan.sistemahospital.ClasesEstaticas;

import javax.swing.JTextField;

public class ValidacionCamposDoctor {
    /*
     * Método para validar los campos del formulario en donde se ingresan los datos
     * del doctor
     */
    public static String validarCampos(JTextField txtNombre, JTextField txtApellido, JTextField txtEspecialidad) {
        if (txtNombre.getText().trim().isEmpty()) {
            txtNombre.requestFocus();
            return "Nombre.";
        }

        if (txtApellido.getText().trim().isEmpty()) {
            txtApellido.requestFocus();
            return "Apellido.";
        }

        if (txtEspecialidad.getText().trim().isEmpty()) {
            txtEspecialidad.requestFocus();
            return "Especialidad.";
        }
        return "";
    }
}
