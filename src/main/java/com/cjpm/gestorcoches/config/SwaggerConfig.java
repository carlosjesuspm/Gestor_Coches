package com.cjpm.gestorcoches.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 *
 * HTML: http://localhost:8080/swagger-ui/index.html#/
 * JSON: http://localhost:8080/v2/api-docs
 */
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI api(){
//
//        return new OpenAPI(DocumentationType.SWAGGER_2)
//
//
//    }
//
//    private ApiInfo apiDetails(){
//        return new ApiInfoBuilder().title("Spring Boot Gestor Coche API REST")
//                .version("1.0").description("Gestor de Coches REST DOCS")
//                .contact(new Contact("Carlos", "http://localhost/8080","carlos@prueba.com" ))
//                .build();
//    }
//}
