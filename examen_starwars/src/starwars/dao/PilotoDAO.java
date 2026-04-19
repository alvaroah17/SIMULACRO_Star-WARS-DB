package starwars.dao;

import starwars.exception.BDException;
import starwars.model.Especie;
import starwars.model.Faccion;
import starwars.model.Piloto;
import starwars.model.Planeta;

import java.sql.*;
import java.util.ArrayList;

public class PilotoDAO {
    private String URL="jdbc:postgresql://localhost:5433/StarWarsDB";
    private String USER="sw_user";
    private String PASSWD="sw_password";

    private ArrayList<Piloto> pilotos;

    public PilotoDAO() throws BDException {
        this.pilotos = new ArrayList<>();
        conexionPilotosBD();
    }

    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }

    public void conexionPilotosBD() throws BDException {
        String sql="SELECT p.id, p.nombre, p.nivel, p.creditos, p.vida_actual, " +
                    " e.id AS id_especie, e.nombre AS nombre_especie, e.bonificador_fuerza, e.bonificador_agilidad, " +
                    "f.id AS id_faccion, f.nombre AS nombre_faccion, " +
                    "pl.id AS id_planeta, pl.nombre AS nombre_planeta, pl.nivel_minimo_acceso "+
                    "FROM pilotos p " +
                    "JOIN especies e ON p.id_especie=e.id " +
                    "JOIN facciones f ON p.id_faccion = f.id " +
                    "JOIN planetas pl ON p.id_planeta_actual = pl.id ";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){

                ///ESPECIE
                int id_especie=resultSet.getInt("id_especie");
                String nombre_especie = resultSet.getString("nombre_especie");
                int bonificador_fuerza= resultSet.getInt("bonificador_fuerza");
                int bonificador_agilidad= resultSet.getInt("bonificador_agilidad");

                Especie especie=new Especie(id_especie,nombre_especie,bonificador_fuerza,bonificador_agilidad);

                ///FACCIONES
                int id_faccion=resultSet.getInt("id_faccion");
                String nombre_faccion = resultSet.getString("nombre_faccion");

                Faccion faccion=new Faccion(id_faccion,nombre_faccion);

                ///PLANETAS
                int id_planeta = resultSet.getInt("id_planeta");
                String nombre_planeta=resultSet.getString("nombre_planeta");
                int nivel_minimo_acceso=resultSet.getInt("nivel_minimo_acceso");

                Planeta planeta = new Planeta(id_planeta, nombre_planeta, nivel_minimo_acceso);

                ///PILOTO
                int id_piloto = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int nivel = resultSet.getInt("nivel");
                int creditos = resultSet.getInt("creditos");
                int vida_actual=resultSet.getInt("vida_actual");

                Piloto piloto = new Piloto(id_piloto, nombre, nivel, creditos,vida_actual, especie, faccion, planeta);
            }


        }catch (SQLException e){
            throw new BDException("ERROR: AL CONECTAR CON LA BD -->"+e.getMessage() );
        }
    }

    public void crearPilotoBD(String nombre, Especie especie, Faccion faccion, Planeta planeta) throws BDException {
        String sql="INSERT INTO pilotos (nombre, nivel, creditos, vida_actual, id_especie, id_faccion, id_planeta_actual) " +
                    "VALUES (?, 1, 100, 100, ?, ?, ?) RETURNING id";
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, especie.getId_especie());
            preparedStatement.setInt(3,faccion.getId_facciones());
            preparedStatement.setInt(4, planeta.getId_planeta());

            ResultSet resulset=preparedStatement.executeQuery();
            if (resulset.next()){
                int idGenerado=resulset.getInt("id");

                Piloto piloto=new Piloto(idGenerado, nombre, 1, 100, 100, especie, faccion, planeta);
                pilotos.add(piloto);
            }
        }catch (SQLException e){
            throw new BDException("ERROR: Al crear el piloto --> "+e.getMessage());
        }
    }
}
