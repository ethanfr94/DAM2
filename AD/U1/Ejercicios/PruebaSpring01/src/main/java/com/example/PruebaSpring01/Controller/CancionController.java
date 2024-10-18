package com.example.PruebaSpring01.Controller;

import com.example.PruebaSpring01.Model.Cancion;
import com.example.PruebaSpring01.Repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")

public class CancionController {
    @Autowired
    private CancionRepository cancionRepository;

    @PostMapping
    public ResponseEntity<?> createCancion(@RequestBody Cancion cancion){
        if(cancionRepository.save(cancion) == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(cancion);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la cancion");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCanciones(){
        List<Cancion> canciones = cancionRepository.findAll();
        if(canciones.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(canciones);
        }
    }
}
