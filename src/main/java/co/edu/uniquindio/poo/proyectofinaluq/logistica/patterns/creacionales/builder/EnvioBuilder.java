package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.builder;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Direccion;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Paquete;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaStrategy;

import java.util.UUID;

public class EnvioBuilder {
    private final String idEnvio = UUID.randomUUID().toString();
    private Direccion origen;
    private Direccion destino;
    private Paquete paquete;
    private TarifaStrategy tarifaStrategy;

    public EnvioBuilder withOrigen(Direccion o){ this.origen = o; return this; }
    public EnvioBuilder withDestino(Direccion d){ this.destino = d; return this; }
    public EnvioBuilder withPaquete(Paquete p){ this.paquete = p; return this; }
    public EnvioBuilder withTarifaStrategy(TarifaStrategy s){ this.tarifaStrategy = s; return this; }

    public Envio build() {
        Envio e = new Envio(idEnvio, origen, destino, paquete);
        if (tarifaStrategy != null) {
            double costo = tarifaStrategy.calcular(e);
            e.setCosto(costo);
        }
        return e;
    }
}
