package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.exception.BDException;
import rpg.model.Personaje;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Ritual {
    private String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private String USER = "xrpg_user";
    private String PASSWD = "xrpg_password";

    private PersonajeDAO personajeDAO;

    public Ritual(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }

    public void procesarRitual(ArrayList<Personaje> expedicion, int idClaseEvolucionada) throws SQLException, BDException {
        String sqlContarEquipadas = "SELECT COUNT(*) FROM Personajes_Habilidades " +
                "WHERE id_personaje = ? AND equipada_combate = true";

        String sqlContarHabilidaes = "SELECT COUNT(*) FROM Personajes_Habilidades " +
                "WHERE id_personaje = ? AND equipada_combate = true OR false";

        String sqlCambiarID = "UPDATE Personajes_Habilidades SET id_personaje = ? " +
                "WHERE id_personaje = ? AND id_habilidad = ?";


        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement preparedStatementContarEquipadas = connection.prepareStatement(sqlContarEquipadas)) {
            Iterator<Personaje> it = expedicion.iterator();
            while (it.hasNext()){
                preparedStatementContarEquipadas.setInt(1, it.next().getId());
                ResultSet resultSet = preparedStatementContarEquipadas.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) == 3) {
                    try (PreparedStatement preparedStatementContar = connection.prepareStatement(sqlContarHabilidaes)) {
                        preparedStatementContar.setInt(1,it.next().getId());
                        if (resultSet.next() && resultSet.getInt(1) > 5){
                            try(PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlCambiarID)) {
                                preparedStatementUpdate.setInt(1,idClaseEvolucionada);
                                preparedStatementUpdate.setInt(2,it.next().getId());

                                preparedStatementUpdate.executeUpdate();

                                it.next().setOro(it.next().getOro()-50);
                                personajeDAO.actualizarOroBD(it.next());

                            }
                        }
                    }
                }
                else if (resultSet.next() && resultSet.getInt(1) == 3 && it.next().getVida_actual()<it.next().getRaza().getBonificadorVida()*0.10)  {
                    it.remove();
                    personajeDAO.actualizarCiudadNUllBD(it.next());
                }
            }
        }catch (SQLException e){

        }
    }
}
