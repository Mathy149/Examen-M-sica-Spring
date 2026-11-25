package com.jr.tienda.repository;

import com.jr.tienda.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    // Caso especial 1: Contar cuántas canciones hay de un género
    long countByGeneroIgnoreCase(String genero);
}
