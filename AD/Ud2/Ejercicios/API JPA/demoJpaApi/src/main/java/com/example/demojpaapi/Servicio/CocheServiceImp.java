package com.example.demojpaapi.Servicio;

import com.example.demojpaapi.Mapper.CocheMapper;
import com.example.demojpaapi.Model.Coche;
import com.example.demojpaapi.Model.CocheDTO;
import com.example.demojpaapi.Repositorio.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CocheServiceImp implements CocheService{

    // Inyectamos el repositorio
    @Autowired
    private CocheRepository repo;

    @Override
    public List<Coche> findAll() {
        return repo.findAll();
    }

    @Override
    // Buscamos un coche por su id y si no lo encuentra devuelve null
    // este metodo devuelve un objeto de tipo Optional<Coche>
    // por lo que usamos el metodo orElse(null) para que si no encuentra el coche devuelva null
    public Coche findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Coche guardar(Coche coche) {
        // el método save crea o modifica (si ya existe) coche
        //Devuelve el coche tras crearlo o modificarlo
        //save es un método de JpaRepository
        return repo.save(coche);
    }
    /*
    @Override
    public Coche modificar(Coche coche, Integer id) {
       if(repo.existsById(id)){
           coche.setId(id);
           return repo.save(coche);
       }else{
           return null;
       }
    }
    */

    @Override
    public Coche modificar(Coche editar, Integer id) {
        Coche coche = repo.findById(id).orElse(null);
        if (coche != null) {
            coche.setMarca(editar.getMarca());
            coche.setModelo(editar.getModelo());
            coche.setPrecio(editar.getPrecio());
            repo.save(coche);
        }
        return coche;
    }

    public Coche delete(Integer id){
        if(repo.existsById(id)){
            Coche coche = repo.findById(id).get();
            repo.delete(coche);
            return coche;
        }else{
            return null;
        }
    }

    private CocheMapper mapper=new CocheMapper();

    @Override
    public CocheDTO findDTOById(int id) {
        Coche coche=findById(id);
        CocheDTO cocheDTO=mapper.toDTO(coche);
        return cocheDTO;
    }

}
