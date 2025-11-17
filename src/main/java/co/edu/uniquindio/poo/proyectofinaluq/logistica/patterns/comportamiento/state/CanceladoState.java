package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public class CanceladoState implements EstadoEnvio {
    public CanceladoState(Envio envio){
    }
    @Override public void asignar(Envio e, Repartidor r){ throw new IllegalStateException("Cancelado"); }
    @Override public void marcarEnRuta(Envio e){ throw new IllegalStateException("Cancelado"); }
    @Override public void marcarEntregado(Envio e){ throw new IllegalStateException("Cancelado"); }
    @Override public void cancelar(Envio e){ /* ya cancelado */ }
    @Override public String getNombre(){ return "Cancelado"; }
}
