package com.example.microserviciodiario.dto;

public class ArchivoMultimediaDTO {
    private String url;
    private String tipo;

    public ArchivoMultimediaDTO() {}

    public ArchivoMultimediaDTO(String url, String tipo) {
        this.url = url;
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}