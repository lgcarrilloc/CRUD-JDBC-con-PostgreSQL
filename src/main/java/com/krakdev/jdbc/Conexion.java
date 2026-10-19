package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {

    private static Connection conexion;

    private static final Logger logger =
            LoggerFactory.getLogger(Conexion.class);

    public static void conectar() {

        try {

            String url =
                    "jdbc:postgresql://localhost:5432/tallerjdbc";

            String usuario = "postgres";

            String password = "luis2809";

            conexion = DriverManager.getConnection( url, usuario, password);

            logger.info("Conexión exitosa");

        } catch (SQLException e) {

            logger.error("Error al conectar", e);

        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void cerrarConexion() {

        try {

            if (conexion != null) {

                conexion.close();

                logger.info("Conexión cerrada");

            }

        } catch (SQLException e) {

            logger.error("Error al cerrar conexión", e);

        }

    }
}