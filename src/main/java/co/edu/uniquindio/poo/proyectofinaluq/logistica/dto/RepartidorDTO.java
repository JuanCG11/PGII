package co.edu.uniquindio.poo.proyectofinaluq.logistica.dto;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.DisponibilidadRepartidor;

public record RepartidorDTO(
        String id,
        String nombre,
        String telefono,
        String zona,
        DisponibilidadRepartidor disponibilidad
) {}
