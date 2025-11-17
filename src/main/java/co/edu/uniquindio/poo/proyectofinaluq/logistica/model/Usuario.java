package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String email;
    private String telefono;
    private final List<Direccion> direcciones = new ArrayList<>();

    public Usuario(String id, String nombre, String email, String telefono) {
        this.idUsuario = id; this.nombre = nombre; this.email = email; this.telefono = telefono;
    }

    // getters y setters
    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<Direccion> getDirecciones() { return direcciones; }

    @Override
    public String toString() { return nombre + " <" + email + ">"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }
}
