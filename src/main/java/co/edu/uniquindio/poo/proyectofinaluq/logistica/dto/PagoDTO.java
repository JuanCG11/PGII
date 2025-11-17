package co.edu.uniquindio.poo.proyectofinaluq.logistica.dto;

public class PagoDTO {
    private final String idPago;
    private final double monto;
    private final String metodo;

    public PagoDTO(String idPago, double monto, String metodo) {
        this.idPago = idPago; this.monto = monto; this.metodo = metodo;
    }
    public double getMonto() { return monto; }
    public String getMetodo() { return metodo; }
    public String getIdPago() { return idPago; }
}
