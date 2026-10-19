package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakdev.entidades.Vehiculo;

public class UpdateVehiculo {

    private static final Logger logger =
            LoggerFactory.getLogger(UpdateVehiculo.class);

    public void actualizar(Vehiculo vehiculo) {

        String sql =
                "UPDATE vehiculos "
                + "SET marca=?, modelo=?, anio=?, "
                + "precio=?, color=?, disponible=? "
                + "WHERE placa=?";

        try {

            PreparedStatement ps =
                    Conexion.getConexion()
                            .prepareStatement(sql);

            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAnio());
            ps.setDouble(4, vehiculo.getPrecio());
            ps.setString(5, vehiculo.getColor());
            ps.setBoolean(6, vehiculo.isDisponible());
            ps.setString(7, vehiculo.getPlaca());

            int filas =
                    ps.executeUpdate();

            logger.info(
                    "Filas actualizadas: {}",
                    filas);

        } catch (SQLException e) {

            logger.error(
                    "Error al actualizar",
                    e);

        }
    }
}