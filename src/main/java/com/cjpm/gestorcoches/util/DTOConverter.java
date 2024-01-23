package com.cjpm.gestorcoches.util;

import org.modelmapper.ModelMapper;


public class DTOConverter {

    private final ModelMapper modelMapper;

    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, D> D convertEntityToDTO(T entity, Class<D> dtoClass){
        return modelMapper.map(entity,dtoClass);
    }

    public <T, D> D convertDTOToEntity(T dto,Class<D> entityClass ){
        return modelMapper.map(dto, entityClass);
    }
}

