package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public class SolicitadoState implements EstadoEnvio {
    public SolicitadoState(Envio envio){
    }

    @Override
    public void asignar(Envio e, Repartidor r) {
        e.setRepartidor(r);
        e.setEstado(new AsignadoState(e));
    }
    @Override public void marcarEnRuta(Envio e){ throw new IllegalStateException("Debe asignarse antes de estar en ruta"); }
    @Override public void marcarEntregado(Envio e){ throw new IllegalStateException("No está en ruta"); }
    @Override public void cancelar(Envio e){ e.setEstado(new CanceladoState(e)); }
    @Override public String getNombre(){ return "Solicitado"; }
}
