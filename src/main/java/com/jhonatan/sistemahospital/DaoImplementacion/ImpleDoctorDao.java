package com.jhonatan.sistemahospital.DaoImplementacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoDoctor;

public class ImpleDoctorDao implements DaoDoctor {
    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /* consultas */
    private static final String SQL_SELECT = "select * from doctor";
    private static final String SQL_INSERT = "insert into doctor (nombre,apellido,especialidad) values (?,?,?)";

    public ImpleDoctorDao() {

    }

    public ImpleDoctorDao(Connection connection) {
        this.conexionMYSQL = connection;
    }

    @Override
    public List<Doctor> listarDoctores() {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;

        List<Doctor> listaDoctores = new ArrayList<Doctor>();
        Doctor doctor;

        try {
            /* */
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_SELECT);
            resultado = consultaPreparada.executeQuery();
            int idDoctor;
            String nombre, apellido, especialidad;
            while (resultado.next()) {
                idDoctor = resultado.getInt("iddoctor");
                nombre = resultado.getString("nombre");
                apellido = resultado.getString("apellido");
                especialidad = resultado.getString("especialidad");

                doctor = new Doctor(idDoctor, nombre, apellido, especialidad);
                /* agregamos al arraylist */
                listaDoctores.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.toString());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return listaDoctores;
    }

    @Override
    public int insertarDoctor(Doctor doctor) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();

            consultaPreparada = conexion.prepareStatement(SQL_INSERT);
            /* se establecemos los valores a la consulta */
            consultaPreparada.setString(1, doctor.getNombre());
            consultaPreparada.setString(2, doctor.getApellido());
            consultaPreparada.setString(3, doctor.getEspecialidad());

            registros = consultaPreparada.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar un doctor: " + e.toString());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        /* retornamos */
        return registros;
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
