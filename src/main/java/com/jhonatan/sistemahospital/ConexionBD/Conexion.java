package com.jhonatan.sistemahospital.ConexionBD;

import java.sql.*;

public class Conexion {
    private Conexion() {

    }

    private static final String URL = "jdbc:mysql://localhost/sistemahospital";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Conexion instancia;

    // método para conectarnos
    public Connection conectarConBaseDatos() throws SQLException {
        System.out.println("Conectado");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void desconectarBD(Connection connection) {
        try {
            connection.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.out.println("Desconectado de la BD");
        }
    }

    public void cerrarResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet: " + e.toString());
        }
    }

    public void cerrarPreparedStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Conexion.cerrarPreparedStatement() : " + e.toString());
        }
    }

    // patron singleton
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
