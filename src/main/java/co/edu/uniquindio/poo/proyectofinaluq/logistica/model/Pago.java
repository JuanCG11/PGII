package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.ResultadoPago;

import java.time.LocalDateTime;

public class Pago {
    private final String idPago;
    private final double monto;
    private final LocalDateTime fecha;
    private final String metodo;
    private ResultadoPago resultado;

    public Pago(String idPago, double monto, String metodo) {
        this.idPago = idPago; this.monto = monto; this.metodo = metodo; this.fecha = LocalDateTime.now();
    }

    public String getIdPago() { return idPago; }
    public double getMonto() { return monto; }
    public LocalDateTime getFecha() { return fecha; }
    public String getMetodo() { return metodo; }
    public ResultadoPago getResultado() { return resultado; }
    public void setResultado(ResultadoPago resultado) { this.resultado = resultado; }
}
