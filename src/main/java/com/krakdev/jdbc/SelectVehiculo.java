package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectVehiculo {

    public void listar() {

        String sql =
                "SELECT * FROM vehiculos";

        try {

            PreparedStatement ps =
                    Conexion.getConexion()
                            .prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

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

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}