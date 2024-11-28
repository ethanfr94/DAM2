package com.proyectos.proyectosapi.controller;

import com.proyectos.proyectosapi.model.Ciclo;
import com.proyectos.proyectosapi.model.Etapa;
import com.proyectos.proyectosapi.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciclos")
public class CicloController {
    @Autowired
    private CicloRepository cicloRepository;

    @GetMapping
    public ResponseEntity<?> getAllCiclos() {
        List<Ciclo> ciclos = cicloRepository.findAll();
        if (ciclos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(ciclos);
        }
    }

    @GetMapping("/codciclo/{codciclo}")
    public ResponseEntity<?> getCicloById(@PathVariable String codciclo) {
        Ciclo ciclo = cicloRepository.findById(codciclo);
        if (ciclo != null) {
            return ResponseEntity.ok(ciclo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/etapa/{etapa}")
    public ResponseEntity<?> getCicloByEtapa(@PathVariable Etapa etapa) {
        List<Ciclo> ciclos = cicloRepository.findByEtapa(etapa);
        if (ciclos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(ciclos);
        }
    }
}
