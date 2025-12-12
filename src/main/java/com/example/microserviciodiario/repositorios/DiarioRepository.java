package com.example.microserviciodiario.repositorios;

import com.example.microserviciodiario.modelos.Diario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface DiarioRepository extends JpaRepository<Diario, UUID> {
    // Buscar todos los diarios que pertenezcan a un usuario X
    List<Diario> findByUsuarioId(UUID usuarioId);
}