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
                "DELETE FROM vehiculos "
                + "WHERE placa=?";

        try {

            PreparedStatement ps =
                    Conexion.getConexion()
                            .prepareStatement(sql);

            ps.setString(1, placa);

            int filas =
                    ps.executeUpdate();

            logger.info(
                    "Filas eliminadas: {}",
                    filas);

        } catch (SQLException e) {

            logger.error(
                    "Error al eliminar",
                    e);

        }
    }
}