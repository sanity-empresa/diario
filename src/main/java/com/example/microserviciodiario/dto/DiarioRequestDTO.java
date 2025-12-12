package com.example.microserviciodiario.dto;

// Ya no necesitamos @Data si lo hacemos manual
// import lombok.Data;

public class DiarioRequestDTO {
    private String titulo;
    private String contenido;

    // --- Constructor Vacío ---
    public DiarioRequestDTO() {
    }

    // --- Constructor con Todo ---
    public DiarioRequestDTO(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    // --- GETTERS Y SETTERS MANUALES ---

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}