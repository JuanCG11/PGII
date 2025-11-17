package co.edu.uniquindio.poo.proyectofinaluq.logistica.repository;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;

import java.util.*;

public class EnvioRepository {
    private final Map<String, Envio> storage = new HashMap<>();
    public void save(Envio e) { storage.put(e.getIdEnvio(), e); }
    public Optional<Envio> findById(String id) { return Optional.ofNullable(storage.get(id)); }
    public List<Envio> findAll(){ return new ArrayList<>(storage.values()); }
    public List<Envio> findByEstado(String estado){
        List<Envio> res = new ArrayList<>();
        for(Envio e: storage.values()) {
            if (e.getEstado() != null && e.getEstado().getNombre().equalsIgnoreCase(estado)) res.add(e);
        }
        return res;
    }
}
