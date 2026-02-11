package com.example.microserviciodiario.servicios;

import com.example.microserviciodiario.dto.BitacoraRequestDTO;
import com.example.microserviciodiario.modelos.BitacoraEmocional;
import com.example.microserviciodiario.modelos.Diario;
import com.example.microserviciodiario.repositorios.BitacoraEmocionalRepository;
import com.example.microserviciodiario.repositorios.DiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BitacoraService {

    @Autowired
    private BitacoraEmocionalRepository bitacoraRepository;

    @Autowired
    private DiarioRepository diarioRepository;

    // Crear una bitácora dentro de un diario específico
    @Transactional
    public BitacoraEmocional crearBitacora(UUID diarioId, BitacoraRequestDTO dto, String emailUsuario) {
        // 1. Buscar el diario y validar que pertenezca al usuario (Seguridad)
        Diario diario = diarioRepository.findById(diarioId)
                .orElseThrow(() -> new RuntimeException("Diario no encontrado"));

        if (!diario.getUsuario().getEmail().equals(emailUsuario)) {
            throw new RuntimeException("No tienes permiso para agregar bitácoras a este diario");
        }

        // 2. Crear la entidad
        BitacoraEmocional bitacora = new BitacoraEmocional();
        bitacora.setEmocionPrincipal(dto.getEmocionPrincipal());
        bitacora.setDescripcion(dto.getDescripcion());
        bitacora.setIntensidad(dto.getIntensidad());
        bitacora.setFechaRegistro(LocalDateTime.now());
        bitacora.setDiario(diario); // Relación

        return bitacoraRepository.save(bitacora);
    }

    // Listar emociones de un diario
    public List<BitacoraEmocional> listarPorDiario(UUID diarioId, String emailUsuario) {
        Diario diario = diarioRepository.findById(diarioId)
                .orElseThrow(() -> new RuntimeException("Diario no encontrado"));

        if (!diario.getUsuario().getEmail().equals(emailUsuario)) {
            throw new RuntimeException("No tienes permiso para ver este diario");
        }

        return bitacoraRepository.findByDiarioId(diarioId);
    }
}