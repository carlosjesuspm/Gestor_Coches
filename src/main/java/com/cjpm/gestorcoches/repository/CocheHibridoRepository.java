package com.cjpm.gestorcoches.repository;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para Coches Híbridos
 */
@Repository
public interface CocheHibridoRepository  extends JpaRepository<CocheElectricoDTO, Long> {
}
