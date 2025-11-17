package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public class EntregadoState implements EstadoEnvio {
    public EntregadoState(Envio envio){
    }
    @Override public void asignar(Envio e, Repartidor r){ throw new IllegalStateException("Ya entregado"); }
    @Override public void marcarEnRuta(Envio e){ throw new IllegalStateException("Ya entregado"); }
    @Override public void marcarEntregado(Envio e){ /* ya entregado */ }
    @Override public void cancelar(Envio e){ throw new IllegalStateException("No se puede cancelar entregado"); }
    @Override public String getNombre(){ return "Entregado"; }
}