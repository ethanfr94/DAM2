package com.example.demojpaapi.Controller;

import com.example.demojpaapi.Model.Coche;
import com.example.demojpaapi.Model.CocheDTO;
import com.example.demojpaapi.Servicio.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CocheController {
    @Autowired
    private CocheService cocheService;

    @GetMapping("/coches")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Coche> coches = cocheService.findAll();
        if(coches.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(coches);
    }

    @GetMapping("/coches/{id}")
    private ResponseEntity<?> obtenerCochePorId(@PathVariable int id){
        CocheDTO coche = cocheService.findDTOById(id);
        if(coche==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(coche);
    }


    /*
    @GetMapping("/coches/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Integer id)
    {
        Coche coche = cocheService.findById(id);
        if(coche==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(coche);
    }
    */

    @PostMapping("/coches")
    public ResponseEntity<Coche> nuevoCoche(@RequestBody Coche nuevo)
    {
    // se ha modificado el nombre guardar en service por save
        Coche guardado = cocheService.guardar(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/coches/{id}")
    public ResponseEntity<?> editarCoche(@RequestBody Coche editar, @PathVariable Integer id)
    {
        Coche coche = cocheService.modificar(editar, id);
        return ResponseEntity.ok(cocheService.guardar(coche));
    }

    @DeleteMapping("/coches/{id}")
    public ResponseEntity<?> borrarCoche(@PathVariable Integer id)
    {
        cocheService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*
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
    */
}
