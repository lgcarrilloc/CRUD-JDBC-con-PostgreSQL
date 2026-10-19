package com.krakedev.tallerjdbc;

import com.krakdev.jdbc.AdminVehiculo;
import com.krakdev.jdbc.Conexion;

public class TallerjdbcApplication {

    public static void main(String[] args) {

        Conexion.conectar();

        AdminVehiculo admin =
                new AdminVehiculo();

        admin.eliminarVehiculo("ABC123");

        Conexion.cerrarConexion();

    }
}