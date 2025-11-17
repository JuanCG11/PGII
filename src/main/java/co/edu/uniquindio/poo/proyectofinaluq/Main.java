package co.edu.uniquindio.poo.proyectofinaluq;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.app.LogisticsApp;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Direccion;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Paquete;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.ServicioAdicional;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LogisticsFacade facade = new LogisticsFacade();

        // registrar usuario (método que esperaba Main originalmente)
        UsuarioDTO u = facade.registrarUsuario("Andres Gomez", "andres@example.com", "3109998888");
        System.out.println("Usuario creado: " + u.nombre() + " id:" + u.id());

        // Ejemplo de cotización
        Direccion origen = new Direccion("o1", "Casa", "Cra 10", "CiudadX", "0,0");
        Direccion destino = new Direccion("d2", "Oficina", "Cl 20", "CiudadX", "0,0");
        Paquete p = new Paquete(3.0, 30, 20, 10);

        EnvioDTO cot = facade.cotizarEnvio(origen, destino, p, List.of(ServicioAdicional.SEGURO.name()));
        System.out.println("Cotizacion: costo=" + cot.costo);

        // Procesar pago simulado (usa PagoDTO)
        PagoDTO pago = new PagoDTO("pay1", cot.costo, "SIMULADO");
        System.out.println("Procesando pago...");
        var pagoRes = facade.procesarPago(pago);
        System.out.println("Resultado pago: " + (pagoRes.getResultado() != null ? pagoRes.getResultado() : "N/A"));
    }
}
