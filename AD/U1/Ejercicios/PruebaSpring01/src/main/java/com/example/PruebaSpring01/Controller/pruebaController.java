package com.example.PruebaSpring01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pruebaController {

    @GetMapping("/saludo") //Indica que es un metodo get para obtener datos
    public String Saludo(){
        return "Hola Te responde la Api";
    }

    @GetMapping("/saludo/{nom}") //Indica que es un metodo get para obtener datos
    public String Saludo(@PathVariable String nom){
        return "Hola "+nom+"Te responde la Api";
    }



}
