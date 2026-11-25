package com.jr.tienda.controller;

import com.jr.tienda.model.Videojuego;
import com.jr.tienda.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @GetMapping
    public List<Videojuego> listar() {
        return videojuegoRepository.findAll();
    }

    @PostMapping
    public Videojuego registrar(@RequestBody Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    // Caso Especial 2
    @GetMapping("/precio")
    public List<Videojuego> porRangoPrecio(@RequestParam double min, @RequestParam double max) {
        return videojuegoRepository.findByPrecioBetween(min, max);
    }
}
