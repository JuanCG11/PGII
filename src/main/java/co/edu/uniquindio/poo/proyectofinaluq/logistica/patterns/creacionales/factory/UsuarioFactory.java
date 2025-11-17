package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.factory;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Usuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;

import java.util.UUID;

public class UsuarioFactory {
    public static Usuario create(String nombre, String email, String telefono, String password, RolUsuario rol) {
        return new Usuario(UUID.randomUUID().toString(), nombre, email, telefono, password, rol);
    }
}
