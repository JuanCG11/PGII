package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator;

public abstract class TarifaDecorator implements TarifaComponent {
    protected final TarifaComponent componente;
    public TarifaDecorator(TarifaComponent componente) { this.componente = componente; }
    @Override public double getCosto() { return componente.getCosto(); }
    @Override public String getDescripcion() { return componente.getDescripcion(); }
}
