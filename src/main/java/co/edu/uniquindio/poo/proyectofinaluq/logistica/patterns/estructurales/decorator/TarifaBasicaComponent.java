package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaBasicaStrategy;

public class TarifaBasicaComponent implements TarifaComponent {
    private final Envio envio;
    public TarifaBasicaComponent(Envio envio) { this.envio = envio; }
    @Override public double getCosto() { return new TarifaBasicaStrategy().calcular(envio); }
    @Override public String getDescripcion() { return "Tarifa básica"; }
}
