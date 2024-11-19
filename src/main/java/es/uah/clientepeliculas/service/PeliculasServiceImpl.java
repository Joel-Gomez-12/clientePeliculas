package es.uah.clientepeliculas.service;


import es.uah.clientepeliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    RestTemplate template;

    @Value("${rest.api.url}")
    private String apiUrl;

    @Override
    public List<Pelicula> obtenerPeliculas() {
        String url = apiUrl + "/peliculas";
        Pelicula[] peliculas = template.getForObject(url, Pelicula[].class);
        return Arrays.asList(peliculas);
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Integer id) {
        String url = apiUrl + "/peliculas/" + id;
        return template.getForObject(url, Pelicula.class);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        String url = apiUrl + "/peliculas";
        template.postForObject(url, pelicula, Void.class);
    }

    @Override
    public void eliminarPelicula(Integer id) {
        String url = apiUrl + "/peliculas/" + id;
        template.delete(url);
    }



}
