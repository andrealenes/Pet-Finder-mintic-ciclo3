/* CONEXION BASE DE DATOS: PETFINDER*/

package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBDPetfinder {
    Connection con;
    String driver = "org.mariadb.jdbc.Driver";
    String dbName = "petfinder";
    String url = "jdbc:mariadb://localhost:3306/"+dbName;
    String usuario = "root";
    String clave = "123456";
    
    public Connection conectarBaseDatos(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("La conexion a la base de datos fue exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion a la base de datos: " + e);
        }
        return con;
    }
}
/*
class prueba{
    public static void main(String[] args) {
        Connection con;
        ConexionBDPetfinder conexion = new ConexionBDPetfinder();
        con = conexion.conectarBaseDatos();
    }
}
 */