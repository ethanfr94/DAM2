package com.example.demojpaapi.Repositorio;

import com.example.demojpaapi.Model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

// CocheRepository trabajara con la entidad Coche y el tipo de dato de su clave primaria es Integer
public interface CocheRepository extends JpaRepository<Coche, Integer> {

}
