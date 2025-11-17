package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public interface EstadoEnvio {
    void asignar(Envio e, Repartidor r);
    void marcarEnRuta(Envio e);
    void marcarEntregado(Envio e);
    void cancelar(Envio e);
    String getNombre();
}
