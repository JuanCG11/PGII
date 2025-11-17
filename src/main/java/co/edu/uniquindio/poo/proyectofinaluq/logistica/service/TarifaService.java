package co.edu.uniquindio.poo.proyectofinaluq.logistica.service;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaBasicaStrategy;

public class TarifaService {
    public double calcular(Envio envio) {
        return new TarifaBasicaStrategy().calcular(envio);
    }
}
