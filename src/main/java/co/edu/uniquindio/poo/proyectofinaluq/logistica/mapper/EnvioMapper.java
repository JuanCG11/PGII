package co.edu.uniquindio.poo.proyectofinaluq.logistica.mapper;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;

public class EnvioMapper {
    public static EnvioDTO toDTO(Envio e) {
        EnvioDTO dto = new EnvioDTO();
        dto.id = e.getIdEnvio();
        dto.origen = e.getOrigen().getAlias();
        dto.destino = e.getDestino().getAlias();
        dto.costo = e.getCosto();
        dto.estado = e.getEstado() != null ? e.getEstado().getNombre() : "N/A";
        dto.fechaCreacion = e.getFechaCreacion();
        dto.idRepartidor = e.getRepartidor() != null ? e.getRepartidor().getIdRepartidor() : null;
        return dto;
    }
}