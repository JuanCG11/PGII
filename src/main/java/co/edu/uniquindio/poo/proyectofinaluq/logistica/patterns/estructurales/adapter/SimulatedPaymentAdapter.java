package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.adapter;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Pago;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.ResultadoPago;

import java.util.UUID;

public class SimulatedPaymentAdapter implements PaymentAdapter {
    @Override
    public Pago processPayment(PagoDTO pagoDTO) {
        Pago p = new Pago(UUID.randomUUID().toString(), pagoDTO.getMonto(), pagoDTO.getMetodo());
        // Lógica simple: si monto > 0 aprobado
        if (pagoDTO.getMonto() > 0) p.setResultado(ResultadoPago.APROBADO);
        else p.setResultado(ResultadoPago.RECHAZADO);
        return p;
    }
}
