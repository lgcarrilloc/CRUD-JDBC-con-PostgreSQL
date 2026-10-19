package com.krakdev.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.krakdev.entidades.Vehiculo;

public class AdminVehiculo {

    private static final Logger logger =
            LoggerFactory.getLogger(AdminVehiculo.class);

    public void insertarVehiculo(Vehiculo vehiculo) {

        String sql = "INSERT INTO vehiculos " + "(placa, marca, modelo, anio, precio, color, disponible) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAnio());
            ps.setDouble(5, vehiculo.getPrecio());
            ps.setString(6, vehiculo.getColor());
            ps.setBoolean(7, vehiculo.isDisponible());
            ps.executeUpdate();

            logger.info("Vehículo insertado correctamente");

        } catch (SQLException e) {
            logger.error("Error al insertar vehículo", e);

        }
    }
    public ArrayList<Vehiculo> consultarVehiculos() {

        ArrayList<Vehiculo> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM vehiculos";

        try {

            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setPrecio(rs.getDouble("precio"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setDisponible(rs.getBoolean("disponible"));
                lista.add(vehiculo);
            }

        } catch (SQLException e) {

            logger.error("Error al consultar vehículos",e);
        }
        return lista;
    }
    
    public void actualizarVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculos " + "SET marca=?, modelo=?, anio=?, " + "precio=?, color=?, disponible=? " + "WHERE placa=?";
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);

            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAnio());
            ps.setDouble(4, vehiculo.getPrecio());
            ps.setString(5, vehiculo.getColor());
            ps.setBoolean(6, vehiculo.isDisponible());
            ps.setString(7, vehiculo.getPlaca());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                logger.info("Vehículo actualizado");
            } else {
                logger.warn("No existe la placa");
            }
        } catch (SQLException e) {
            logger.error("Error al actualizar vehículo", e);
        }
    }
    
    public void eliminarVehiculo(String placa) {

        String sql ="DELETE FROM vehiculos " + "WHERE placa=?";
        
        try {

            PreparedStatement ps =Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, placa);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                logger.info("Vehículo eliminado");
            } else {
                logger.warn("No existe la placa");

            }

        } catch (SQLException e) {
            logger.error( "Error al eliminar vehículo",e);

        }
    }
}