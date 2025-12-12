package com.example.microserviciodiario.repositorios;

import com.example.microserviciodiario.modelos.ArchivoMultimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ArchivoMultimediaRepository extends JpaRepository<ArchivoMultimedia, UUID> {
    // Buscar archivos de un diario específico
    List<ArchivoMultimedia> findByDiarioId(UUID diarioId);
}