package com.proyectos.proyectosapi.controller;


import com.proyectos.proyectosapi.model.*;
import com.proyectos.proyectosapi.repository.RealizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realizan")
public class RealizaController {
    @Autowired
    private RealizaRepository realizaRepository;

    @GetMapping
    public ResponseEntity<?> getAllRealiza() {
        List<Realiza> realizan = realizaRepository.findAll();
        if (realizan.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(realizan);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getRealizaById(@PathVariable int id) {
        Realiza realiza = realizaRepository.findById(id);
        if (realiza != null) {
            return ResponseEntity.ok(realiza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/alumno/{alumno}")
    public ResponseEntity<?> getRealizaByAlumno(@PathVariable String alumno) {
        Realiza realiza = realizaRepository.findByAlumno(alumno);
        if (realiza != null) {
            return ResponseEntity.ok(realiza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/proyecto/{proyecto}")
    public ResponseEntity<?> getRealizaByProyecto(@PathVariable int proyecto) {
        Realiza realiza = realizaRepository.findByProyecto(proyecto);
        if (realiza != null) {
            return ResponseEntity.ok(realiza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<?> createRealiza(@RequestBody Realiza realiza) {
        if (realizaRepository.save(realiza) == 1)
            return ResponseEntity.status(HttpStatus.CREATED).body(realiza);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo insertar la realización");
    }
    @PutMapping("{id}")
    public ResponseEntity<Realiza> updateRealiza(@RequestBody Realiza realiza) {
       Realiza existingRealiza=realizaRepository.findById(realiza.getId());
        if(existingRealiza!=null){
            realizaRepository.update(realiza);
            return ResponseEntity.ok(realiza);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{realiza}")
    public ResponseEntity<Void> deleteRealiza(@RequestBody Realiza realiza) {
        Realiza existingRealiza=realizaRepository.findById(realiza.getId());
        if(existingRealiza!=null){
            realizaRepository.delete(realiza);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
