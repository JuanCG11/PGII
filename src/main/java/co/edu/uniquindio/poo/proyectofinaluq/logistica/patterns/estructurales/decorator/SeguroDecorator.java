package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator;

public class SeguroDecorator extends TarifaDecorator {
    public SeguroDecorator(TarifaComponent c) { super(c); }
    @Override public double getCosto() { return super.getCosto() + 2000; }
    @Override public String getDescripcion() { return super.getDescripcion() + " + Seguro"; }
}
