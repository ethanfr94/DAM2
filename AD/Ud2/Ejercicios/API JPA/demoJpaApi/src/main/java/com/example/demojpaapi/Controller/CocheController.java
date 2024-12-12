package com.example.demojpaapi.Controller;

import com.example.demojpaapi.Model.Coche;
import com.example.demojpaapi.Servicio.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CocheController {
    @Autowired
    private CocheService cocheService;

    @GetMapping("/coches")
    public List<Coche> obtenerTodos(){
        return cocheService.findAll();
    }
    @GetMapping("/coches/{id}")
    public Coche obtenerUno(@PathVariable Integer id){
        return cocheService.findById(id);
    }

    @PostMapping("/coches")
    public Coche nuevoCoche(@RequestBody Coche nuevo)
    {
        return cocheService.guardar(nuevo); //lo mas lógico sería save
    }

    @PutMapping("/coches/{id}")
    public Coche modificarCoche(@RequestBody Coche coche, @PathVariable Integer id){
        return cocheService.modificar(coche, id);
    }

    @DeleteMapping("/coches/{id}")
    public Coche borrarCoche(@PathVariable Integer id)
    {
        return cocheService.delete(id);
    }

}
