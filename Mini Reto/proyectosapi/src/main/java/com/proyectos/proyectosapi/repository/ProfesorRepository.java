package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Profesor;

import java.util.List;

public interface ProfesorRepository {
    List<Profesor> findAll();

    Profesor findById(String id);

    List<Profesor> findByAdmin(boolean admin);

    Profesor findByNombre(String nombre, String apellidos);

    Profesor findByEmailYContraseña(String email, String contraseña);

    int save(Profesor profesor);

    int update(Profesor profesor);

    int delete(Profesor profesor);

}
