package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Evalua;
import com.proyectos.proyectosapi.model.Profesor;
import com.proyectos.proyectosapi.model.Proyecto;

import java.util.List;

public interface EvaluaRepository {
    List<Evalua> findAll();

    Evalua findById(int id);

    List<Evalua> findByProfesor(String profesor);

    List<Evalua> findByProyecto(int proyecto);

    int save(Evalua evalua);

    int update(Evalua evalua);

    int delete(int id);
}
