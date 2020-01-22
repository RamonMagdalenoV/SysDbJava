package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author Pro
 */
public class Conexion {

    private Connection cone;
    private final String USER = "root";
    private final String PASS = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "jdbc:mysql://127.0.0.1/maxdb";

    public Conexion() {
        try {
            Class.forName(DRIVER);
            cone = DriverManager.getConnection(SERVER, USER, PASS);
            System.out.println("Correcto!!");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR de driver: " + e.toString());
        } catch (SQLException e) {
            System.out.println("ERROR de conexion: " + e.toString());
        }
    }
    
    public Connection getConnection(){
        return cone;
    }

}
