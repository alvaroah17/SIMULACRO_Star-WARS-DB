package starwars.model;

public class Especie {
    private int id_especie;
    private String nombre;
    private int bonificador_fuerza;
    private int bonificador_agilidad;

    public Especie(int id_especie, String nombre, int bonificador_fuerza, int bonificador_agilidad) {
        this.id_especie = id_especie;
        this.nombre = nombre;
        this.bonificador_fuerza = bonificador_fuerza;
        this.bonificador_agilidad = bonificador_agilidad;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBonificador_fuerza() {
        return bonificador_fuerza;
    }

    public void setBonificador_fuerza(int bonificador_fuerza) {
        this.bonificador_fuerza = bonificador_fuerza;
    }

    public int getBonificador_agilidad() {
        return bonificador_agilidad;
    }

    public void setBonificador_agilidad(int bonificador_agilidad) {
        this.bonificador_agilidad = bonificador_agilidad;
    }
}
