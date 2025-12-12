package com.example.microserviciodiario.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "archivos_multimedia")
public class ArchivoMultimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String urlRecurso;
    private String tipoArchivo;
    private String descripcion;
    private LocalDateTime fechaSubida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diario_id", nullable = false)
    private Diario diario;

    @PrePersist
    protected void onCreate() {
        fechaSubida = LocalDateTime.now();
    }
}