package com.krakedev.tallerjdbc;

import com.krakdev.jdbc.Conexion;
import com.krakdev.jdbc.SelectVehiculo;

public class TallerjdbcApplication {

    public static void main(String[] args) {

        try {

            Conexion.conectar();

            SelectVehiculo select =
                    new SelectVehiculo();

            select.listar();

        } catch (Exception e) {

            System.out.println(
                    "Error general: "
                    + e.getMessage());

        } finally {

            Conexion.cerrarConexion();

            System.out.println(
                    "Proceso finalizado");

        }
    }
}