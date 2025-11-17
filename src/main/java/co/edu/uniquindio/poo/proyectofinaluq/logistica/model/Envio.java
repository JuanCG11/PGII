package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.observer.EnvioSubject;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.EstadoEnvio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Envio {
    private final String idEnvio;
    private final Direccion origen;
    private final Direccion destino;
    private final Paquete paquete;
    private double costo;
    private EstadoEnvio estado;
    private final LocalDateTime fechaCreacion;
    private LocalDateTime fechaEstimada;
    private Repartidor repartidor;
    private final List<String> serviciosAdicionales = new ArrayList<>();

    // subject para observer
    private final EnvioSubject subject = new EnvioSubject();

    public Envio(String idEnvio, Direccion origen, Direccion destino, Paquete paquete) {
        this.idEnvio = idEnvio;
        this.origen = origen;
        this.destino = destino;
        this.paquete = paquete;
        this.fechaCreacion = LocalDateTime.now();
    }

    // getters y setters
    public String getIdEnvio() { return idEnvio; }
    public Direccion getOrigen() { return origen; }
    public Direccion getDestino() { return destino; }
    public Paquete getPaquete() { return paquete; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public EstadoEnvio getEstado() { return estado; }
    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
        subject.notifyAll(this, estado);
    }
    public Repartidor getRepartidor() { return repartidor; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    public List<String> getServiciosAdicionales() { return serviciosAdicionales; }
    public void addServicio(String s) { serviciosAdicionales.add(s); }
    public EnvioSubject getSubject() { return subject; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
