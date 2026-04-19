package starwars.model;

public class Piloto {
    private int id_piloto;
    private String nombre;
    private int nivel;
    private int creditos;
    private int vida_actual;
    private Especie especie;
    private Faccion faccion;
    private Planeta planeta;

    public Piloto(int id_piloto, String nombre, int nivel, int creditos, int vida_actual, Especie especie, Faccion faccion, Planeta planeta) {
        this.id_piloto = id_piloto;
        this.nombre = nombre;
        this.nivel = nivel;
        this.creditos = creditos;
        this.vida_actual = vida_actual;
        this.especie = especie;
        this.faccion = faccion;
        this.planeta = planeta;
    }

    public int getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(int id_piloto) {
        this.id_piloto = id_piloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}
