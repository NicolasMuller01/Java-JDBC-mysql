package Parte1_JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //Conexion Datos
        String url = "jdbc:mysql://localhost:3306/sistema";
        String user = "root";
        String password = "";

        //Campos de la tabla en MySql
        String campoNombre = "nombre";
        String campoTelefono = "telefono";

        //Consultas
        String consultaSelect = "SELECT * FROM registro where nombre = ?";

        try {

            //Llamada a la base de datos
            Connection mySql = DriverManager.getConnection(url,user,password);

            //Statement
            PreparedStatement hojaVirtual = mySql.prepareStatement(consultaSelect);
            hojaVirtual.setString(1,"nico");
            ResultSet resultado = hojaVirtual.executeQuery();
            //utilizamos metodo get para obtener los valores
            while (resultado.next()) {
                System.out.println(resultado.getString("id"));
            }
        }
        catch (Exception e) {
            System.out.println("no funco");
        }
    }
}