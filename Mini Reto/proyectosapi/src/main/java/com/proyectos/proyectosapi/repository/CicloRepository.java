package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Ciclo;
import com.proyectos.proyectosapi.model.Etapa;


import java.util.List;

public interface CicloRepository
{
    List<Ciclo> findAll();
    Ciclo findById(String codCiclo);
    List <Ciclo> findByEtapa(Etapa etapa);
}
