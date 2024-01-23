package com.cjpm.gestorcoches.util;

public class ModelMapper {

    /**
     * Establece la conversión de entity a DTO
     * @return ModelMapper
     */

    public org.modelmapper.ModelMapper modelMapper() {
        return new org.modelmapper.ModelMapper();
    }
}
