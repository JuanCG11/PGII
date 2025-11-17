package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.observer;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.EstadoEnvio;

public interface EnvioObserver {
    void onEstadoCambiado(Envio envio, EstadoEnvio nuevoEstado);
}
