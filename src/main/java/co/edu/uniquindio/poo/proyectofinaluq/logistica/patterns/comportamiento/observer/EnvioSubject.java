package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.observer;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.EstadoEnvio;

import java.util.ArrayList;
import java.util.List;

public class EnvioSubject {
    private final List<EnvioObserver> observers = new ArrayList<>();
    public void subscribe(EnvioObserver o) { observers.add(o); }
    public void unsubscribe(EnvioObserver o) { observers.remove(o); }
    public void notifyAll(Envio envio, EstadoEnvio nuevo) {
        for (EnvioObserver o : observers) o.onEstadoCambiado(envio, nuevo);
    }
}
