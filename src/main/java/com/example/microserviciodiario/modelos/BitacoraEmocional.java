package com.example.microserviciodiario.modelos;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bitacoras_emocionales")
public class BitacoraEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "emocion_principal", nullable = false)
    private String emocionPrincipal;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private int intensidad; // 1-10

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Relación con Diario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diario_id", nullable = false)
    @JsonIgnore // Evitamos bucles infinitos al convertir a JSON
    private Diario diario;

    // --- CONSTRUCTOR VACÍO ---
    public BitacoraEmocional() {}

    // --- GETTERS Y SETTERS MANUALES ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getEmocionPrincipal() { return emocionPrincipal; }
    public void setEmocionPrincipal(String emocionPrincipal) { this.emocionPrincipal = emocionPrincipal; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getIntensidad() { return intensidad; }
    public void setIntensidad(int intensidad) { this.intensidad = intensidad; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Diario getDiario() { return diario; }
    public void setDiario(Diario diario) { this.diario = diario; }
}