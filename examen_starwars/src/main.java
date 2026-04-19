import starwars.dao.EspecieDAO;
import starwars.model.Especie;

public class main {
    public static void main(String[] args) {
        EspecieDAO especieDAO=new EspecieDAO();
        for ( Especie especies :especieDAO.getEspecies()){
            System.out.println(especies.getNombre());
        }
    }
}
