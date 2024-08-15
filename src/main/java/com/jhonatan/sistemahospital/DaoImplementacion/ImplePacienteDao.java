package com.jhonatan.sistemahospital.DaoImplementacion;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Paciente;
import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoPaciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplePacienteDao implements DaoPaciente {

    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();
    /* consultas */
    private static final String SQL_INSERT = "INSERT INTO paciente (nombre,apellido,genero,fechaNacimiento,ciudad,id_Provincia,alergias,peso,altura) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Paciente> listarDoctores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertarPaciente(Paciente paciente) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();

            consultaPreparada = conexion.prepareStatement(SQL_INSERT);
            consultaPreparada.setString(1, paciente.getNombre());
            consultaPreparada.setString(2, paciente.getApellido());
            consultaPreparada.setString(3, String.valueOf(paciente.getGenero()));
            java.sql.Date sqlDate = new java.sql.Date(paciente.getFechaNacimiento().getTime());
            consultaPreparada.setDate(4, sqlDate);
            consultaPreparada.setString(5, paciente.getCiudad());
            consultaPreparada.setString(6, String.valueOf(paciente.getIdProvincia()));
            consultaPreparada.setString(7, paciente.getAlergias());
            consultaPreparada.setDouble(8, paciente.getPeso());
            consultaPreparada.setDouble(9, paciente.getAltura());

            registros = consultaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar un paciente: " + e.toString());
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
    public int modificarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente obtenerInformacionPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Provincia> listarProvincias() {
        List<Provincia> listaProvincias = new ArrayList<>();
        String SQL_NOMBRE_FABRICANTE = "SELECT idprovincia,nombre FROM provincia";

        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_NOMBRE_FABRICANTE);
            resultado = consultaPreparada.executeQuery();
            while (resultado.next()) {
                Provincia p = new Provincia();
                p.setIdProvincia(resultado.getString("idprovincia").charAt(0));
                p.setNombre(resultado.getString("nombre"));
                listaProvincias.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar pacientes en el combo box: " + e.toString());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return listaProvincias;
    }
}
