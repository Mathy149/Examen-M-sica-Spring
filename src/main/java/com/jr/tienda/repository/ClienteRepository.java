package com.jr.tienda.repository;

import com.jr.tienda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Caso especial 3: Clientes de una ciudad
    List<Cliente> findByCiudadIgnoreCase(String ciudad);
}
