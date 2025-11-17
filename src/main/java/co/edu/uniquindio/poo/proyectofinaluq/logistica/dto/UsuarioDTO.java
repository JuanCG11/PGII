package co.edu.uniquindio.poo.proyectofinaluq.logistica.dto;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;

public record UsuarioDTO(
        String id,
        String nombre,
        String email,
        String telefono,
        RolUsuario rol
) {}
