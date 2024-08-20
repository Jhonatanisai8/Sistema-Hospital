package com.jhonatan.sistemahospital.DaoImplementacion;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Paciente;
import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoPaciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ImplePacienteDao implements DaoPaciente {
    
    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();
    /* consultas */
    private static final String SQL_INSERT = "INSERT INTO paciente (nombre,apellido,genero,fechaNacimiento,ciudad,id_provincia,alergias,peso,altura) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_LISTAR01 = "select * from paciente";
    private static final String SQL_LISTARPACIENTE_PROVINCIA = "SELECT "
            + " paciente.id_paciente,"
            + " paciente.nombre,"
            + " paciente.apellido,"
            + " paciente.genero,"
            + " paciente.fechaNacimiento,"
            + " paciente.ciudad,"
            + " provincia.nombre,"
            + " paciente.alergias,"
            + " paciente.peso,"
            + " paciente.altura"
            + " FROM paciente "
            + " INNER JOIN provincia ON paciente.id_provincia = provincia.id_provincia"
            + " ORDER BY paciente.nombre";
    
    private static final String QSL_DELETE = "DELETE FROM paciente WHERE idpaciente = ?";
    
    @Override
    public List<Paciente> listarPacientes(String nombre) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        
        List<Paciente> listaPacientes = null;
        String SQL_LISTAR = "SELECT * FROM paciente WHERE nombre LIKE '%" + nombre + "%'";
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            String SQL_SELECT = nombre.isEmpty() ? SQL_LISTAR01 : SQL_LISTAR;
            consultaPreparada = conexion.prepareStatement(SQL_SELECT);
            resultado = consultaPreparada.executeQuery();
            listaPacientes = new ArrayList<>();
            
            while (resultado.next()) {
                Paciente paciente = new Paciente(
                        resultado.getInt("id_paciente"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("genero").charAt(0),
                        resultado.getDate("fechaNacimiento"),
                        resultado.getString("ciudad"),
                        resultado.getInt("id_provincia"),
                        resultado.getString("alergias"),
                        resultado.getDouble("peso"),
                        resultado.getDouble("altura"));
                listaPacientes.add(paciente);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return listaPacientes;
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
            consultaPreparada.setInt(6, paciente.getIdProvincia());
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
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(QSL_DELETE);
            consultaPreparada.setInt(1, paciente.getIdPaciente());
            registros = consultaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar una paciente: " + e.getMessage());
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
    public Paciente obtenerInformacionPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Provincia> listarProvincias() {
        List<Provincia> listaProvincias = new ArrayList<>();
        String SQL_NOMBRE_FABRICANTE = "SELECT id_provincia,nombre FROM provincia";
        
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_NOMBRE_FABRICANTE);
            resultado = consultaPreparada.executeQuery();
            while (resultado.next()) {
                Provincia p = new Provincia();
                p.setIdProvincia(resultado.getInt("id_provincia"));
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
    
    public void listarTabla(DefaultTableModel model) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        ResultSetMetaData datos = null;
        
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_LISTARPACIENTE_PROVINCIA);
            resultado = consultaPreparada.executeQuery();
            datos = resultado.getMetaData();
            
            int cantidadColumnas = datos.getColumnCount();
            
            while (resultado.next()) {
                Object arreglo[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                model.addRow(arreglo);
            }
        } catch (SQLException e) {
            System.out.println("listar en tabla: " + e.getMessage());
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
