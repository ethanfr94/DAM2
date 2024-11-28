package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.*;

import java.util.List;

public interface RealizaRepository {
    List<Realiza> findAll();

    Realiza findById(int id);

    Realiza findByAlumno(String alumno);

    Realiza findByProyecto(int proyecto);

    int save(Realiza realiza);

    int update(Realiza realiza);

    int delete(Realiza realiza);
}
