package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.adapter;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Pago;

public interface PaymentAdapter {
    Pago processPayment(PagoDTO pagoDTO);
}
