package co.edu.uniquindio.poo.proyectofinaluq.logistica.repository;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

import java.util.*;

public class RepartidorRepository {
    private final Map<String, Repartidor> storage = new HashMap<>();
    public void save(Repartidor r) { storage.put(r.getIdRepartidor(), r); }
    public Optional<Repartidor> findById(String id) { return Optional.ofNullable(storage.get(id)); }
    public List<Repartidor> findAll() { return new ArrayList<>(storage.values()); }
    public void delete(String id) { storage.remove(id); }
}
