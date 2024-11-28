package com.proyectos.proyectosapi.repository;


import com.proyectos.proyectosapi.model.Proyecto;

import java.util.List;

public interface ProyectoRepository {
    List<Proyecto> findAll();

    List<Proyecto> findByTipo(String tipo);

    Proyecto findByNombre(String nombre);

    Proyecto findById(int id);

    int save(Proyecto proyecto);

    int update(Proyecto proyecto);

    int delete(Proyecto proyecto);
}
