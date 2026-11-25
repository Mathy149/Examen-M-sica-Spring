package com.jr.tienda.repository;

import com.jr.tienda.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    // Caso especial 2: Videojuegos con precio en un rango (usamos min y max)
    List<Videojuego> findByPrecioBetween(double min, double max);
}
