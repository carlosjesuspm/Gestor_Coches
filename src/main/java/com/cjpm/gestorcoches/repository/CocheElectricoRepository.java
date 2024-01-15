package com.cjpm.gestorcoches.repository;


import com.cjpm.gestorcoches.entities.CocheElectrico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para Coches Eléctricos
 */
@Repository
public interface CocheElectricoRepository  extends JpaRepository<CocheElectrico, Long> {
}
