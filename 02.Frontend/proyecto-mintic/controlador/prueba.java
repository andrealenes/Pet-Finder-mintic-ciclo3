package controlador;

import java.sql.Connection;
/* 
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/

public class prueba{
    public static void main(String[] args) {
        Connection con;
        ConexionBDPetfinder conexion = new ConexionBDPetfinder();
        con = conexion.conectarBaseDatos();
    }
}
