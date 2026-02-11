package com.example.microserviciodiario.repositorios;

import com.example.microserviciodiario.modelos.BitacoraEmocional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface BitacoraEmocionalRepository extends JpaRepository<BitacoraEmocional, UUID> {

    List<BitacoraEmocional> findByDiarioId(UUID diarioId);
}