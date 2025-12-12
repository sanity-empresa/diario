package com.example.microserviciodiario.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "bitacoras_emocionales")
public class BitacoraEmocional {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tipoEmocion;
    private Integer intensidad;

    @Column(columnDefinition = "TEXT")
    private String notasAdicionales;

    private LocalTime horaRegistro;

    // Relación Muchas Bitácoras -> Un Diario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diario_id", nullable = false)
    private Diario diario;
}