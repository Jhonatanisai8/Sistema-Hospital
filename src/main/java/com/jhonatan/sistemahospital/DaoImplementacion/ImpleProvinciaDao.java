package com.jhonatan.sistemahospital.DaoImplementacion;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoProvincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImpleProvinciaDao implements DaoProvincia {

    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /*CONSULTAS*/
    private static final String SQL_SELECT = "SELECT * FROM provincia";
    private static final String SQL_INSERT = "INSERT INTO provincia (idprovincia,nombre) VALUES (?,?)";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";

    @Override
    public List<Provincia> listarProvincias() {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;

        List<Provincia> listaProvincias = new ArrayList<>();

        Provincia provincia;
        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SQL_SELECT);
            resultado = consultaPreparada.executeQuery();

            char idProvincia;
            String nombre;

            while (resultado.next()) {
                idProvincia = resultado.getString("idprovincia").charAt(0);
                nombre = resultado.getString("nombre");

                provincia = new Provincia(idProvincia, nombre);

                listaProvincias.add(provincia);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar provincias: " + e.getMessage());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            instanciaMYSQL.cerrarResultSet(resultado);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }
        return listaProvincias;
    }

    @Override
    public int insertarProvincia(Provincia provincia) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        int registros = 0;

        try {
            conexion = this.conexionMYSQL != null ? this.conexionMYSQL : instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareCall(SQL_INSERT);
            /*le pasamos los valores a la consulta*/
            consultaPreparada.setObject(1, provincia.getIdProvincia());
            consultaPreparada.setString(2, provincia.getNombre());

            registros = consultaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar Provincia: " + e.getMessage());
        } finally {
            instanciaMYSQL.cerrarPreparedStatement(consultaPreparada);
            if (this.conexionMYSQL == null) {
                instanciaMYSQL.desconectarBD(conexion);
            }
        }

        return registros;
    }

    @Override
    public int modificarProvincia(Provincia provincia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminarProvincia(Provincia provincia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Provincia obtenerInformacion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void listarEnTabla(DefaultTableModel model) {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        ResultSetMetaData datos = null;

        String SELECT = "SELECT idprovincia,nombre FROM provincia";
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            consultaPreparada = conexion.prepareStatement(SELECT);
            resultado = consultaPreparada.executeQuery();

            int cantidadColumnas = datos.getColumnCount();

            while (resultado.next()) {
                Object arreglo[] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                model.addRow(arreglo);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las provincias en el tabla: " + e.getMessage());
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
