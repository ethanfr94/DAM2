package org.example.gestorapi.repository;

import org.example.gestorapi.model.Actividad;
import org.example.gestorapi.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    List<Contrato> findContratoByActividadId(Integer id);


}
