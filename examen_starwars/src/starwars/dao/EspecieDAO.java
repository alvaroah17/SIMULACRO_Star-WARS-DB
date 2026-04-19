package starwars.dao;

import starwars.model.Especie;

import java.sql.*;
import java.util.ArrayList;

public class EspecieDAO {
    private String URL="jdbc:postgresql://localhost:5433/StarWarsDB";
    private String USER="sw_user";
    private String PASSWD="sw_password";

    private ArrayList<Especie> especies;

    public EspecieDAO() {
        this.especies = new ArrayList<>();
        conexionEspecieBD();
    }

    public void conexionEspecieBD (){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM especies" )){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_especie = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int bonificador_fuerza=resultSet.getInt("bonificador_fuerza");
                int bonificador_agilidad=resultSet.getInt("bonificador_agilidad");
                Especie especie=new Especie(id_especie, nombre, bonificador_fuerza, bonificador_agilidad);
                especies.add(especie);
            }
        }catch (SQLException e){

        }
    }

    public ArrayList<Especie> getEspecies() {
        return especies;
    }
}
