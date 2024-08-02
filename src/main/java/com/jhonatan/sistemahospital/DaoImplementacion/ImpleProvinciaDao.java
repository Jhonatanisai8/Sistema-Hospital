package com.jhonatan.sistemahospital.DaoImplementacion;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.InterfacesDao.DaoProvincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImpleProvinciaDao implements DaoProvincia {
    
    private Connection conexionMYSQL;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /*CONSULTAS*/
    private static final String SQL_SELECT = "SELECT * FROM provincia";
    private static final String SQL_INSERT = "";
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
            
        } catch (Exception e) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
}
