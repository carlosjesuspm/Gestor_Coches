package com.cjpm.gestorcoches.repository;



import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para Coches de Combustión
 */

@Repository
public interface CocheCombustionRepository  extends JpaRepository<CocheCombustionDTO, Long> {
}
