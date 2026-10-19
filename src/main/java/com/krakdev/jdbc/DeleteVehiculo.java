package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteVehiculo {

    private static final Logger logger =
            LoggerFactory.getLogger(DeleteVehiculo.class);

    public void eliminar(String placa) {

        String sql =
                "DELETE FROM vehiculos WHERE placa=?";

        PreparedStatement ps = null;

        try {

            ps = Conexion.getConexion().prepareStatement(sql);

            ps.setString(1, placa);

            int filas = ps.executeUpdate();

            if (filas > 0) {

                System.out.println("Vehículo eliminado");
                logger.info("Vehículo eliminado");

            } else {

                System.out.println("Vehículo no encontrado");
            }

        } catch (SQLException e) {

            System.out.println("Error de conexión");
            logger.error("Error de conexión", e);

        } finally {

            try {

                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException e) {

                logger.error("Error al cerrar PreparedStatement", e);
            }
        }
    }
}