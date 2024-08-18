package com.jhonatan.sistemahospital.DaoImplementacion;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Admision;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoAdmision;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ImpleAdmisionDao implements DaoAdmision {

    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    private static final String SQL_SELECT_PACIENTES = "SELECT idpaciente,concat(nombre,' ',apellido) AS NOMBRE_PACIENTE FROM paciente";
    private static final String SQL_SELECT_DOCTORES = "SELECT iddoctor,concat(nombre,' ',apellido) AS NOMBRE_DOCTOR FROM doctor";
    private static final String SQL_INSERT_ADMISION = "INSERT INTO admision (id_Paciente,fechaAdmision,fechaAlta,diagnostico,id_doctor) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_ADMISION = "SELECT admision.id_Paciente,"
            + "CONCAT(paciente.nombre,' ',paciente.apellido),"
            + " admision.fechaAdmision,"
            + " admision.fechaAlta,"
            + " admision.diagnostico,"
            + " admision.id_doctor,"
            + " CONCAT(doctor.nombre,' ',doctor.apellido)"
            + " FROM admision"
            + " INNER JOIN paciente ON admision.id_Paciente = paciente.idpaciente"
            + " INNER JOIN doctor ON admision.id_doctor = doctor.iddoctor";

    @Override

    public List<Admision> listarAdmisiones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertarAdmision(Admision admision) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;

        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_INSERT_ADMISION);

            //le pasamos los parametros
            consultaPreparada.setInt(1, admision.getIdPaciente());

            //le pasamos las fechas
            java.sql.Date dateFechaAdmision = new java.sql.Date(admision.getFechaAdmision().getTime());
            consultaPreparada.setDate(2, dateFechaAdmision);

            java.sql.Date dateFechaAlta = new java.sql.Date(admision.getFechaAlta().getTime());
            consultaPreparada.setDate(3, dateFechaAlta);

            consultaPreparada.setString(4, admision.getDiagnostico());
            consultaPreparada.setInt(5, admision.getIdDoctor());

            registros = consultaPreparada.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            System.out.println("error al insertar una admision: " + e.getMessage());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return registros;
    }

    @Override
    public int modificarAdmision(Admision admision) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminarAdmision(Admision admision) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Admision obtenerInformacion(int idAdmision) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void listarEnTablaPacientes(DefaultTableModel modelo, String pacienteOdoctor) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        ResultSetMetaData datos = null;

        /*depende del parametro que le enviemos listara los pacientes o los doctores*/
        String sqlSelect = pacienteOdoctor.isEmpty() ? SQL_SELECT_PACIENTES : SQL_SELECT_DOCTORES;
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(sqlSelect);

            resultado = consultaPreparada.executeQuery();
            datos = resultado.getMetaData();

            int cantidadColumnas = datos.getColumnCount();

            while (resultado.next()) {
                Object arreglo[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las pacientes o doctores: " + e.getMessage());
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

    public void listarEnTablaAdmisiones(DefaultTableModel modelo) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        ResultSetMetaData datos = null;

        /*depende del parametro que le enviemos listara los pacientes o los doctores*/
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_SELECT_ADMISION);

            resultado = consultaPreparada.executeQuery();
            datos = resultado.getMetaData();

            int cantidadColumnas = datos.getColumnCount();

            while (resultado.next()) {
                Object arreglo[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las admisiones: " + e.getMessage());
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

}
