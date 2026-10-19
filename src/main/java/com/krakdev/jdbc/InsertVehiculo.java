package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakdev.entidades.Vehiculo;

public class InsertVehiculo {

    private static final Logger logger =
            LoggerFactory.getLogger(InsertVehiculo.class);

    public void insertar(Vehiculo vehiculo) {

        String sql =
                "INSERT INTO vehiculos "
                + "(placa, marca, modelo, anio, precio, color, disponible) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps =
                    Conexion.getConexion().prepareStatement(sql);

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAnio());
            ps.setDouble(5, vehiculo.getPrecio());
            ps.setString(6, vehiculo.getColor());
            ps.setBoolean(7, vehiculo.isDisponible());

            int filas = ps.executeUpdate();

            logger.info("Filas insertadas: {}", filas);

        } catch (SQLException e) {

            logger.error("Error al insertar vehículo", e);

        }
    }
}

