package com.example.PruebaSpring01.Controller;


import com.example.PruebaSpring01.Model.Grupo;
import com.example.PruebaSpring01.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que es un controlador rest
@RequestMapping("/grupos") //Indica la ruta de acceso a este controlador

public class GrupoController {
    @Autowired //Inyeccion de dependencias para no tener que instanciar el objeto
    private GrupoRepository grupoRepository;

    /*@GetMapping //Indica que es un metodo get para obtener datos
    public List<Grupo> getAllGrupos(){
        return grupoRepository.findAll();
    }*/

    /*@PostMapping //Indica que es un metodo post para enviar datos al servidor
    public String createGrupo(@RequestBody Grupo grupo){//RequestBody indica que el objeto viene en formato json
        int result = grupoRepository.save(grupo);
        if(result == 1){
            return "Grupo "+grupo.getNombre()+" creado con exito";
        }
        return "Error al crear el grupo";
    }*/

    @PostMapping
    public ResponseEntity<?> createGrupo2(@RequestBody Grupo grupo){//RequestBody indica que el objeto viene en formato json
        if(grupoRepository.save(grupo) == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(grupo);//Si se crea el grupo devolvemos un 201
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el grupo");//Si no se crea devolvemos un 500
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllGrupos2(){//ResponseEntity es una clase que nos permite devolver un objeto con un codigo de estado
        List<Grupo> grupos = grupoRepository.findAll();
        if(grupos.isEmpty()){
            return ResponseEntity.notFound().build();  //Si la lista esta vacia devolvemos un 404
        }
        else{
            return ResponseEntity.ok(grupos);//Si la lista tiene datos devolvemos un 200
        }
    }
}
