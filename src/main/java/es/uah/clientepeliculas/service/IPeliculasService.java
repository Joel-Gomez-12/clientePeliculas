package es.uah.clientepeliculas.service;

import es.uah.clientepeliculas.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> obtenerPeliculas();
    Pelicula obtenerPeliculaPorId(Integer idPelicula);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);

}
