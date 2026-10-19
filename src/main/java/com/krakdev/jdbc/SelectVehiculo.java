package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectVehiculo {

    private static final Logger logger =
            LoggerFactory.getLogger(SelectVehiculo.class);

    public void listar() {

        String sql =
                "SELECT * FROM vehiculos";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = Conexion.getConexion()
                    .prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("placa")
                                + " | "
                                + rs.getString("marca")
                                + " | "
                                + rs.getString("modelo")
                                + " | "
                                + rs.getInt("anio")
                                + " | "
                                + rs.getDouble("precio")
                                + " | "
                                + rs.getString("color")
                                + " | "
                                + rs.getBoolean("disponible"));
            }

            logger.info("Consulta realizada");

        } catch (SQLException e) {

            System.out.println("Error de conexión");
            logger.error("Error de conexión", e);

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException e) {

                logger.error(
                        "Error al cerrar recursos",
                        e);
            }
        }
    }
}