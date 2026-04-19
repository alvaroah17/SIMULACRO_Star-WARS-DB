package starwars;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private String URL="jdbc:postgresql://localhost:5433/StarWarsDB";
    private String USER="sw_user";
    private String PASSWD="sw_password";
    public void conexion(){
        Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
    }
}
