package starwars.model;

public class Planeta {
    private int id_planeta;
    private String nombre;
    private int nivel_minimo_acceso;

    public Planeta(int id_planeta, String nombre, int nivel_minimo_acceso) {
        this.id_planeta = id_planeta;
        this.nombre = nombre;
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }

    public int getId_planeta() {
        return id_planeta;
    }

    public void setId_planeta(int id_planeta) {
        this.id_planeta = id_planeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_minimo_acceso() {
        return nivel_minimo_acceso;
    }

    public void setNivel_minimo_acceso(int nivel_minimo_acceso) {
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }
}
