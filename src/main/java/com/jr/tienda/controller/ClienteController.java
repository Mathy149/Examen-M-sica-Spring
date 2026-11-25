package com.jr.tienda.controller;

import com.jr.tienda.model.Cliente;
import com.jr.tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente registrar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Caso Especial 3
    @GetMapping("/ciudad")
    public List<Cliente> porCiudad(@RequestParam String nombre) {
        return clienteRepository.findByCiudadIgnoreCase(nombre);
    }
}
