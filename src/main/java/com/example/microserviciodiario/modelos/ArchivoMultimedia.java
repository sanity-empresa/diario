package com.example.microserviciodiario.modelos;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "archivos_multimedia")
public class ArchivoMultimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String url; // En un caso real, aquí iría la URL de Azure Blob Storage

    @Column(nullable = false)
    private String tipo; // Ej: "IMAGEN", "VIDEO", "AUDIO"

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diario_id", nullable = false)
    @JsonIgnore
    private Diario diario;

    public ArchivoMultimedia() {}

    // --- GETTERS Y SETTERS MANUALES ---
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(LocalDateTime fechaSubida) { this.fechaSubida = fechaSubida; }

    public Diario getDiario() { return diario; }
    public void setDiario(Diario diario) { this.diario = diario; }
}