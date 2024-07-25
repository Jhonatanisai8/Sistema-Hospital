package com.jhonatan.sistemahospital.DaoImplementacion;

import java.sql.*;
import java.util.List;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoDoctor;

public class ImpleDoctorDao implements DaoDoctor {
    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /* consultas */
    private static final String SQL_SELECT = "select * from doctor";

    public ImpleDoctorDao() {

    }

    public ImpleDoctorDao(Connection connection) {
        this.conexionMYSQL = connection;
    }

    @Override
    public List<Doctor> listarDoctores() {
        return null;
    }

    @Override
    public int insertarDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Unimplemented method 'insertarDoctor'");
    }

    @Override
    public int modificarDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Unimplemented method 'modificarDoctor'");
    }

    @Override
    public int eliminarDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarDoctor'");
    }

}
