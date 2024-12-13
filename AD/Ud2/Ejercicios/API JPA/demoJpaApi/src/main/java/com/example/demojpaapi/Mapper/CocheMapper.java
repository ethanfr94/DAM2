package com.example.demojpaapi.Mapper;

import com.example.demojpaapi.Model.Coche;
import com.example.demojpaapi.Model.CocheDTO;

public class CocheMapper {

    public CocheDTO toDTO(Coche coche) {
        CocheDTO dto = new CocheDTO();
        dto.setId(coche.getId());
        dto.setMarca(coche.getMarca());
        dto.setModelo(coche.getModelo());
        dto.setPrecio(coche.getPrecio());
        dto.setIdPropietario(coche.getPropietario() != null ? coche.getPropietario().getId() : null);
        return dto;
    }


}
