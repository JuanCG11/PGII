package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;

public class TarifaBasicaStrategy implements TarifaStrategy {
    @Override
    public double calcular(Envio envio) {
        double base = 3000;
        double pesoFactor = envio.getPaquete().getPeso() * 800;
        double volFactor = envio.getPaquete().getVolumen() * 200;
        double prioridad = envio.getServiciosAdicionales().contains("PRIORITARIO") ? 5000 : 0;
        return base + pesoFactor + volFactor + prioridad;
    }
}
