package com.jhonatan.sistemahospital.DaoImplementacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoDoctor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImpleDoctorDao implements DaoDoctor {

    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /* consultas */
    private static final String SQL_SELECT = "select * from doctor";
    private static final String SQL_INSERT = "insert into doctor (nombre,apellido,especialidad) values (?,?,?)";
    private static final String SQL_UPDATE = "update doctor set nombre = ?, apellido = ?, especialidad = ? where id_doctor = ?";
    private static final String SQL_DELETE = "delete from doctor where id_doctor = ?";
    private static final String SQL_SELECT_DOCTOR = "SELECT * FROM doctor WHERE id_doctor = ? LIMIT 1";

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

        List<Doctor> listaDoctores = new ArrayList<>();
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

        } catch (SQLException e) {
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
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;

        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_UPDATE);

            /* le asiganamos parametros a la consulta */
            consultaPreparada.setString(1, doctor.getNombre());
            consultaPreparada.setString(2, doctor.getApellido());
            consultaPreparada.setString(3, doctor.getEspecialidad());
            consultaPreparada.setInt(4, doctor.getIdDoctor());

            registros = consultaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al momento de modificar un doctor: " + e.toString());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            /* cerramos la conexion */
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return registros;
    }

    @Override
    public int eliminarDoctor(Doctor doctor) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();

            consultaPreparada = conexion.prepareStatement(SQL_DELETE);
            consultaPreparada.setInt(1, doctor.getIdDoctor());

            registros = consultaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar un doctor: " + e.toString());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            /* cerramos la conexion */
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return registros;
    }

    @Override
    public Doctor obtenerInformacion(int id) {
        Doctor doctor = null;
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_SELECT_DOCTOR);

            consultaPreparada.setInt(1, id);
            resultado = consultaPreparada.executeQuery();

            while (resultado.next()) {
                /*uso del constructor con todos los parametros*/
                doctor = new Doctor(
                        resultado.getInt("id_doctor"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("especialidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la informacion del doctor");
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return doctor;
    }

    private void listarEnTabla(DefaultTableModel modelo, JTable tblDoctores) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        String SELECT = "SELECT id_doctor,nombre,apellido,especialidad FROM doctor";
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SELECT);
            resultado = consultaPreparada.executeQuery();

            int cantidadColumnas = resultado.getMetaData().getColumnCount();

            Object[] filas = new Object[cantidadColumnas];

            int numeracion = 1;

            while (resultado.next()) {
                filas[0] = numeracion++;
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

            tblDoctores.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al listar en tabla los doctores: ");
        } finally {
            /*cerramos*/
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            /*cerramos la conexion*/
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
    }

    private void vaciarTabla(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void mostrarLista(DefaultTableModel modelo, JTable tblDoctores) {
        this.vaciarTabla(modelo);
        this.listarEnTabla(modelo, tblDoctores);
    }

}
