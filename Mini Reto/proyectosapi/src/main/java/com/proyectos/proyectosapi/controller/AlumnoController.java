package com.proyectos.proyectosapi.controller;

import com.proyectos.proyectosapi.model.Alumno;
import com.proyectos.proyectosapi.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<?> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        if (alumnos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(alumnos);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getAlumnoByDni(@PathVariable String dni) {
        Alumno alumno = alumnoRepository.findByDni(dni);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getAlumnoByEmail(@PathVariable String email) {
        Alumno alumno = alumnoRepository.findByEmail(email);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
        if (alumnoRepository.save(alumno) == 1)
            return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo insertar el alumno");
    }

    @PutMapping("{idalumno}")
    public ResponseEntity<Alumno> updateAlumno(@RequestBody Alumno alumno){
        Alumno existingAlumno=alumnoRepository.findById(alumno.getIdAlumno());
        if(existingAlumno!=null){
            alumnoRepository.update(alumno);
            return ResponseEntity.ok(alumno);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idAlumno}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable String idAlumno){
        Alumno existingAlumno=alumnoRepository.findById(idAlumno);
        if(existingAlumno!=null){
            alumnoRepository.delete(existingAlumno);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
