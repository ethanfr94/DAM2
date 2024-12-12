package com.example.demojpaapi.Servicio;

import com.example.demojpaapi.Model.Coche;

import java.util.List;

public interface CocheService {
    List<Coche> findAll();
    Coche findById(Integer id);
    Coche guardar(Coche coche);
    Coche modificar(Coche coche, Integer id);
    Coche delete(Integer id);
}
