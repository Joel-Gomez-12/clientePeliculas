package es.uah.clientepeliculas.service;

import es.uah.clientepeliculas.model.Actor;

import java.util.List;

public interface IActoresService {

    List<Actor> obtenerActores();
    Actor obtenerActorPorId(Integer id);
    void guardarActor(Actor actor);
    void eliminarActor(Integer id);
}
