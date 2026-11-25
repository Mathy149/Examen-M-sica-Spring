package com.jr.tienda.controller;

import com.jr.tienda.model.Cancion;
import com.jr.tienda.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    @Autowired
    private CancionRepository cancionRepository;

    @GetMapping
    public List<Cancion> listar() {
        return cancionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> buscar(@PathVariable Long id) {
        return cancionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cancion crear(@RequestBody Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizar(@PathVariable Long id, @RequestBody Cancion datos) {
        return cancionRepository.findById(id).map(c -> {
            c.setTitulo(datos.getTitulo());
            c.setArtista(datos.getArtista());
            c.setAlbum(datos.getAlbum());
            c.setGenero(datos.getGenero());
            c.setDuracionSegundos(datos.getDuracionSegundos());
            return ResponseEntity.ok(cancionRepository.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cancionRepository.existsById(id)) {
            cancionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Caso Especial 1
    // Caso Especial 1
    @GetMapping("/conteo")
    public Map<String, Object> contarPorGenero(@RequestParam String genero) {
        long cantidad = cancionRepository.countByGeneroIgnoreCase(genero);
        Map<String, Object> respuesta = new java.util.HashMap<>();
        respuesta.put("genero", genero);
        respuesta.put("cantidad", cantidad);
        return respuesta;
    }
}