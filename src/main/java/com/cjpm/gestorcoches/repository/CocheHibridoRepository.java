package com.cjpm.gestorcoches.repository;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para Coches Híbridos
 */
@Repository
public interface CocheHibridoRepository  extends JpaRepository<CocheHibrido, Long> {
}
