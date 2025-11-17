package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Envio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Repartidor;

public class AsignadoState implements EstadoEnvio {
    public AsignadoState(Envio envio){
    }

    @Override public void asignar(Envio e, Repartidor r){ e.setRepartidor(r); }
    @Override public void marcarEnRuta(Envio e){ e.setEstado(new EnRutaState(e)); }
    @Override public void marcarEntregado(Envio e){ throw new IllegalStateException("Debe estar en ruta"); }
    @Override public void cancelar(Envio e){ e.setEstado(new CanceladoState(e)); }
    @Override public String getNombre(){ return "Asignado"; }
}
