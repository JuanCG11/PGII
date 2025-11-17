package co.edu.uniquindio.poo.proyectofinaluq.logistica.service;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Pago;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.adapter.PaymentAdapter;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.adapter.SimulatedPaymentAdapter;

public class PaymentService {
    private final PaymentAdapter adapter = new SimulatedPaymentAdapter();
    public Pago procesar(PagoDTO dto) { return adapter.processPayment(dto); }
}
