package co.edu.uniquindio.poo.proyectofinaluq.logistica.service;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;

import java.util.List;

public class ReportService {
    // Stub simple: genera CSV como string
    public String generarCSV_Envios(List<Envio> envios) {
        StringBuilder sb = new StringBuilder();
        sb.append("id,origen,destino,costo,estado,fecha\n");
        for (Envio e : envios) {
            sb.append(e.getIdEnvio()).append(",")
                    .append(e.getOrigen().getAlias()).append(",")
                    .append(e.getDestino().getAlias()).append(",")
                    .append(e.getCosto()).append(",")
                    .append(e.getEstado() != null ? e.getEstado().getNombre() : "N/A").append(",")
                    .append(e.getFechaCreacion()).append("\n");
        }
        return sb.toString();
    }
}
