package co.edu.uniquindio.poo.proyectofinaluq.logistica.repository;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Usuario;

import java.util.*;

public class UsuarioRepository {
    private final Map<String, Usuario> storage = new HashMap<>();
    public void save(Usuario u) { storage.put(u.getIdUsuario(), u); }
    public Optional<Usuario> findById(String id) { return Optional.ofNullable(storage.get(id)); }
    public List<Usuario> findAll() { return new ArrayList<>(storage.values()); }
    public void delete(String id) { storage.remove(id); }
}
