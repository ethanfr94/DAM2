package com.proyectos.proyectosapi.controller;


import com.proyectos.proyectosapi.model.Evalua;
import com.proyectos.proyectosapi.model.Profesor;
import com.proyectos.proyectosapi.repository.EvaluaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluan")
public class EvaluaController {
    @Autowired
    private EvaluaRepository evaluaRepository;

    @GetMapping
    public ResponseEntity<?> getAllEvaluan() {
        List<Evalua> evaluan = evaluaRepository.findAll();
        if (evaluan.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(evaluan);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getEvaluanById(@PathVariable int id) {
        Evalua evalua = evaluaRepository.findById(id);
        if (evalua != null) {
            return ResponseEntity.ok(evalua);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/profesor/{profesor}")
    public ResponseEntity<?> getEvaluanByProfesor(@PathVariable String profesor) {
        List<Evalua> evaluan = evaluaRepository.findByProfesor(profesor);
        if (evaluan.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(evaluan);
        }
    }
    @GetMapping("/proyecto/{proyecto}")
    public ResponseEntity<?> getEvaluanByProyecto(@PathVariable int proyecto) {
        List<Evalua> evaluan = evaluaRepository.findByProyecto(proyecto);
        if (evaluan.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(evaluan);
        }
    }
    @PostMapping
    public ResponseEntity<?> createEvalua(@RequestBody Evalua evalua) {
        if (evaluaRepository.save(evalua) == 1)
            return ResponseEntity.status(HttpStatus.CREATED).body(evalua);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo insertar la evaluacion");
    }
    @PutMapping("{id}")
    public ResponseEntity<Evalua> updateEvalua(@RequestBody Evalua evalua){
        Evalua existingEvalua=evaluaRepository.findById(evalua.getId());
        if(existingEvalua!=null){
            evaluaRepository.update(evalua);
            return ResponseEntity.ok(evalua);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEvalua(@PathVariable int id){
        Evalua existingEvalua=evaluaRepository.findById(id);
        if(existingEvalua!=null){
            evaluaRepository.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
