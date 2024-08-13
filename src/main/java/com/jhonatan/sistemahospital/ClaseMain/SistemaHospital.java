package com.jhonatan.sistemahospital.ClaseMain;

import com.jhonatan.sistemahospital.Igu.Dashboard;

public class SistemaHospital {

    public static void main(String[] args) {
        llamarFormularioPrincipal();
    }

    public static void llamarFormularioPrincipal() {
        Dashboard d = new Dashboard();
        d.setVisible(true);
    }
}
