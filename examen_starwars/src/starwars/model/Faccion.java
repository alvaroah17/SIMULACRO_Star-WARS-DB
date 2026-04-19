package starwars.model;

public class Faccion {
    private int id_facciones;
    private String nombre;

    public Faccion(int id_facciones, String nombre) {
        this.id_facciones = id_facciones;
        this.nombre = nombre;
    }

    public int getId_facciones() {
        return id_facciones;
    }

    public void setId_facciones(int id_facciones) {
        this.id_facciones = id_facciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
