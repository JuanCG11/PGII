package co.edu.uniquindio.poo.proyectofinaluq.logistica.dto;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Direccion;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Paquete;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

import java.time.LocalDateTime;

public class EnvioDTO {
    public String id;
    public String origen;
    public String destino;
    public double costo;
    public String estado;
    public LocalDateTime fechaCreacion;
    public String idRepartidor;

    public EnvioDTO() {}
}
