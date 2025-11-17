package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.factory;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Direccion;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Paquete;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.SolicitadoState;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaBasicaStrategy;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaStrategy;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.builder.EnvioBuilder;

import java.util.List;
import java.util.UUID;

public class EnvioFactory {
    /**
     * Crea un Envío usando Builder internamente,
     * aplicando servicios adicionales, estado inicial,
     * estrategia de tarifa y un ID único.
     */
    public static Envio crearEnvio(
            Direccion origen,
            Direccion destino,
            Paquete paquete,
            List<String> serviciosAdicionales
    ) {

        // Estrategia por defecto (puede cambiarse dinámicamente)
        TarifaStrategy estrategia = new TarifaBasicaStrategy();

        // Construcción inicial con Builder
        Envio envio = new EnvioBuilder()
                .withOrigen(origen)
                .withDestino(destino)
                .withPaquete(paquete)
                .withTarifaStrategy(estrategia)
                .build();

        // ID garantizado desde factory
        if (envio.getIdEnvio() == null || envio.getIdEnvio().isEmpty()) {
            envio = new Envio(UUID.randomUUID().toString(), origen, destino, paquete);
        }

        // Aplicamos costo
        double costo = estrategia.calcular(envio);
        envio.setCosto(costo);

        // Servicios adicionales (seguro, prioridad, etc.)
        if (serviciosAdicionales != null) {
            serviciosAdicionales.forEach(envio::addServicio);
        }

        // Estado inicial del patrón State
        envio.setEstado(new SolicitadoState(envio));

        return envio;
    }
}
