package com.example.microserviciodiario.dto;

public class BitacoraRequestDTO {
    private String emocionPrincipal; // Ej: "Alegría", "Tristeza"
    private String descripcion;
    private int intensidad; // Ej: 1 a 10

    public BitacoraRequestDTO() {}

    public BitacoraRequestDTO(String emocionPrincipal, String descripcion, int intensidad) {
        this.emocionPrincipal = emocionPrincipal;
        this.descripcion = descripcion;
        this.intensidad = intensidad;
    }

    // Getters y Setters Manuales
    public String getEmocionPrincipal() { return emocionPrincipal; }
    public void setEmocionPrincipal(String emocionPrincipal) { this.emocionPrincipal = emocionPrincipal; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getIntensidad() { return intensidad; }
    public void setIntensidad(int intensidad) { this.intensidad = intensidad; }
}