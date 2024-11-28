package com.proyectos.proyectosapi.controller;

import com.proyectos.proyectosapi.model.Profesor;
import com.proyectos.proyectosapi.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping
    public ResponseEntity<?> getAllProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        if (profesores.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profesores);
        }
    }
    @GetMapping("/idprofesor/{idProfesor}")
    public ResponseEntity<?> getProfesorById(@PathVariable String idProfesor) {
       Profesor profesor = profesorRepository.findById(idProfesor);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/admin/{admin}")
    public ResponseEntity<?> getProfesorByAdmin(@PathVariable boolean admin) {
       List<Profesor> profesores= profesorRepository.findByAdmin(admin);
        if (profesores.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profesores);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getProfesorByNombre(@PathVariable String nombre, String apellidos) {
        Profesor profesor = profesorRepository.findByNombre(nombre, apellidos);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getProfesorByEmailYContraseña(@PathVariable String email, String contraseña) {
        Profesor profesor = profesorRepository.findByEmailYContraseña(email,contraseña);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<?> createProfesor(@RequestBody Profesor profesor) {
        if (profesorRepository.save(profesor) == 1)
            return ResponseEntity.status(HttpStatus.CREATED).body(profesor);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo insertar el profesor");
    }
    @PutMapping("{idprofesor}")
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor){
       Profesor existingProfesor=profesorRepository.findById(profesor.getIdProfesor());
        if(existingProfesor!=null){
            profesorRepository.update(profesor);
            return ResponseEntity.ok(profesor);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idProfesor}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable String idProfesor){
        Profesor existingProfesor=profesorRepository.findById(idProfesor);
        if(existingProfesor!=null){
            profesorRepository.delete(existingProfesor);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
