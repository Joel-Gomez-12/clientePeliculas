package es.uah.clientepeliculas.service;

import es.uah.clientepeliculas.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService{

    @Autowired
    RestTemplate template;

    @Value("${rest.api.url}")
    private String apiUrl;

    @Override
    public List<Actor> obtenerActores() {
        String url = apiUrl + "/actores";
        Actor[] actores = template.getForObject(url, Actor[].class);
        return Arrays.asList(actores);
    }

    @Override
    public Actor obtenerActorPorId(Integer id) {
        String url = apiUrl + "/actores/" + id;
        return template.getForObject(url, Actor.class);
    }

    @Override
    public void guardarActor(Actor actor) {
        String url = apiUrl + "/actores";
        template.postForObject(url, actor, Void.class);
    }

    @Override
    public void eliminarActor(Integer id) {
        String url = apiUrl + "/actores/" + id;
        template.delete(url);
    }

}
