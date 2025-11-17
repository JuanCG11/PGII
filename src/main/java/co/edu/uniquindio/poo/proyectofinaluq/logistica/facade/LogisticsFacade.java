package co.edu.uniquindio.poo.proyectofinaluq.logistica.facade;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.app.LogisticsApp;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.*;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.builder.EnvioBuilder;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.factory.EnvioFactory;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.factory.UsuarioFactory;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.SeguroDecorator;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.TarifaBasicaComponent;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.TarifaComponent;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.service.PaymentService;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.service.TarifaService;

import java.util.List;
import java.util.UUID;

public class LogisticsFacade {
    private final LogisticsApp app = LogisticsApp.getInstance();
    private final TarifaService tarifaService = app.getTarifaService();
    private final PaymentService paymentService = app.getPaymentService();

    // Usuarios
    public UsuarioDTO registrarUsuario(String nombre, String email, String telefono) {
        Usuario u = UsuarioFactory.create(nombre,email,telefono);
        app.getUsuarioRepo().save(u);
        UsuarioDTO dto = new UsuarioDTO();
        dto.id = u.getIdUsuario(); dto.nombre = u.getNombre(); dto.email = u.getEmail(); dto.telefono = u.getTelefono();
        return dto;
    }

    // Cotizar
    public EnvioDTO cotizarEnvio(Direccion origen, Direccion destino, Paquete paquete, List<String> servicios) {
        Envio envio = EnvioFactory.crearEnvio(origen, destino, paquete, servicios);
        // calculo con decorador si hay servicios
        TarifaComponent componente = new TarifaBasicaComponent(envio);
        if (servicios != null && servicios.contains("SEGURO")) componente = new SeguroDecorator(componente);
        double costo = componente.getCosto();
        envio.setCosto(costo);

        EnvioDTO dto = new EnvioDTO();
        dto.idEnvio = envio.getIdEnvio();
        dto.origen = origen.getAlias();
        dto.destino = destino.getAlias();
        dto.costo = costo;
        dto.estado = envio.getEstado() != null ? envio.getEstado().getNombre() : "NUEVO";
        dto.fechaCreacion = envio.getFechaCreacion();
        return dto;
    }

    // Crear envio definitivo
    public Envio crearEnvio(Envio envio) {
        if (envio.getIdEnvio() == null || envio.getIdEnvio().isEmpty()) {
            envio = new Envio(UUID.randomUUID().toString(), envio.getOrigen(), envio.getDestino(), envio.getPaquete());
        }
        app.getEnvioRepo().save(envio);
        return envio;
    }

    // Pagar
    public Pago procesarPago(PagoDTO dto) {
        return paymentService.procesar(dto);
    }

    // Listar envios
    public List<Envio> listarEnvios() { return app.getEnvioRepo().findAll(); }
}
