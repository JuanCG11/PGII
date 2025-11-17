package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.DisponibilidadRepartidor;

import java.util.Objects;

public class Repartidor {
    private final String idRepartidor;
    private final String nombre;
    private final String documento;
    private final String telefono;
    private DisponibilidadRepartidor disponibilidad;
    private final String zona;

    public Repartidor(String id, String nombre, String documento, String telefono, DisponibilidadRepartidor disp, String zona) {
        this.idRepartidor = id; this.nombre = nombre; this.documento = documento; this.telefono = telefono; this.disponibilidad = disp; this.zona = zona;
    }

    // getters y setters
    public String getIdRepartidor() { return idRepartidor; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTelefono() { return telefono; }
    public DisponibilidadRepartidor getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(DisponibilidadRepartidor disponibilidad) { this.disponibilidad = disponibilidad; }
    public String getZona() { return zona; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repartidor that)) return false;
        return Objects.equals(idRepartidor, that.idRepartidor);
    }
}
