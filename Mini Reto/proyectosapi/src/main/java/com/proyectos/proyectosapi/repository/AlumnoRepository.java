package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Alumno;

import java.util.List;

public interface AlumnoRepository {

    List<Alumno> findAll();

    Alumno findByDni(String dni);

    Alumno findByEmail(String email);

    Alumno findById(String idAlumno);

    int save(Alumno alumno);

    int update(Alumno alumno);

    int delete(Alumno alumno);
}
