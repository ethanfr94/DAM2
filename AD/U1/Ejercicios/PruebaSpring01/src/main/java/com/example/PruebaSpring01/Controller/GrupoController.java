package com.example.PruebaSpring01.Controller;


import com.example.PruebaSpring01.Model.Grupo;
import com.example.PruebaSpring01.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que es un controlador rest
@RequestMapping("/grupos") //Indica la ruta de acceso a este controlador

public class GrupoController {
    @Autowired //Inyeccion de dependencias para no tener que instanciar el objeto
    private GrupoRepository grupoRepository;

    @GetMapping //Indica que es un metodo get para obtener datos
    public List<Grupo> getAllGrupos(){
        return grupoRepository.findAll();
    }

    @PostMapping //Indica que es un metodo post para enviar datos al servidor
    public String createGrupo(@RequestBody Grupo grupo){//RequestBody indica que el objeto viene en formato json
        int result = grupoRepository.save(grupo);
        if(result == 1){
            return "Grupo "+grupo.getNombre()+" creado con exito";
        }
        return "Error al crear el grupo";
    }
}
