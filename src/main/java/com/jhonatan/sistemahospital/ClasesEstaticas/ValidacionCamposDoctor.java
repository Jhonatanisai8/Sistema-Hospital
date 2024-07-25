package com.jhonatan.sistemahospital.ClasesEstaticas;

import javax.swing.JTextField;

public class ValidacionCamposDoctor {
    /*
     * Método para validar los campos del formulario en donde se ingresan los datos
     * del doctor
     */
    public static String validarCampos(JTextField txtNombre, JTextField txtApellido, JTextField txtEspecialidad) {
        String mensaje = "";
        if (txtNombre.getText().trim().isEmpty()) {
            mensaje = "Nombre.";
            txtNombre.requestFocus();
        }

        if (txtApellido.getText().trim().isEmpty()) {
            mensaje = "Apellido.";
            txtApellido.requestFocus();
        }

        if (txtEspecialidad.getText().trim().isEmpty()) {
            mensaje = "Especialidad.";
            txtEspecialidad.requestFocus();
        }
        return mensaje;
    }
}
