package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;

public interface TarifaStrategy {
    double calcular(Envio envio);
}
