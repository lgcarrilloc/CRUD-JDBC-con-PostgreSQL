package com.krakedev.tallerjdbc;

import com.krakdev.jdbc.Conexion;
import com.krakdev.jdbc.SelectVehiculo;

public class TallerjdbcApplication {

    public static void main(String[] args) {

        Conexion.conectar();

        SelectVehiculo select =
                new SelectVehiculo();

        select.listar();

        Conexion.cerrarConexion();

    }
}