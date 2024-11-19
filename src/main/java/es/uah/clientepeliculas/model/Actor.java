package es.uah.clientepeliculas.model;

import java.util.HashSet;
import java.util.Set;

public class Actor {
    private Integer idActor;
    private String nombre;
    private String paisNacimiento;
    private String fechaNacimiento;
    private Set<Pelicula> peliculas = new HashSet<>();

    public Actor(Integer idActor, String nombre, String paisNacimiento, String fechaNacimiento) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.paisNacimiento = paisNacimiento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Actor() {
    }


    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
