package com.krakedev.tallerjdbc;

import com.krakdev.jdbc.Conexion;

public class TallerjdbcApplication {

    public static void main(String[] args) {

        Conexion.conectar();

        Conexion.cerrarConexion();

    }
}