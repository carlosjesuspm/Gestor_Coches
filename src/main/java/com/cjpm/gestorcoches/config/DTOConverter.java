package com.cjpm.gestorcoches.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
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

