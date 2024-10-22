package com.example.PruebaSpring01.Repository;

import com.example.PruebaSpring01.Model.Cancion;

import java.util.List;

public interface CancionRepository {
    List<Cancion> findAll();
    Cancion findByNumCancion(int id);
    List<Cancion> findByGrupo(int grupo);
    int save(Cancion cancion);
    int update(Cancion cancion);
    int deleteByNumCancion(int id);
}
