package com.jr.tienda.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String plataforma;
    private String clasificacion;
    private double precio;
    private LocalDate anioLanzamiento;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public LocalDate getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(LocalDate anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
}