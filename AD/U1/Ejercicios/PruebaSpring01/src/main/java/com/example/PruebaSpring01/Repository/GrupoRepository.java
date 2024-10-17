package com.example.PruebaSpring01.Repository;

import com.example.PruebaSpring01.Model.Grupo;

import java.util.List;

public interface GrupoRepository {
    List<Grupo> findAll();
    Grupo findById(int id);
    Grupo findByLocalidad(String localidad);
    int save(Grupo grupo);
    int update(Grupo grupo);
    int delete(int id);

}

