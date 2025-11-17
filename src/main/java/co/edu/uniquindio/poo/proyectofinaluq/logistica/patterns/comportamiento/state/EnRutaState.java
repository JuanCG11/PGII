package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public class EnRutaState implements EstadoEnvio {
    public EnRutaState(Envio envio){
    }

    @Override public void asignar(Envio e, Repartidor r){ throw new IllegalStateException("Ya asignado"); }
    @Override public void marcarEnRuta(Envio e){ /* ya en ruta */ }
    @Override public void marcarEntregado(Envio e){ e.setEstado(new EntregadoState(e)); }
    @Override public void cancelar(Envio e){ throw new IllegalStateException("No se puede cancelar en ruta"); }
    @Override public String getNombre(){ return "En Ruta"; }
}
