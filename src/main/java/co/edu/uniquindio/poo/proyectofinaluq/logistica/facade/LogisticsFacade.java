package co.edu.uniquindio.poo.proyectofinaluq.logistica.facade;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.PagoDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.RepartidorDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.*;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.DisponibilidadRepartidor;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.ResultadoPago;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.ServicioAdicional;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.EstadoEnvio;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.state.SolicitadoState;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.comportamiento.strategy.TarifaBasicaStrategy;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.factory.EnvioFactory;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.SeguroDecorator;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.TarifaBasicaComponent;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.estructurales.decorator.TarifaComponent;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.EnvioRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.RepartidorRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.UsuarioRepository;

import java.util.*;
import java.util.stream.Collectors;

public class LogisticsFacade {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();
    private final RepartidorRepository repartidorRepo = new RepartidorRepository();
    private final EnvioRepository envioRepo = new EnvioRepository();

    // ----------------- LOGIN / USUARIOS -----------------
    public UsuarioDTO loginUsuario(String email, String password) {
        return usuarioRepo.login(email, password).map(this::toUsuarioDTO).orElse(null);
    }

    // método más corto solicitado por Main
    public UsuarioDTO registrarUsuario(String nombre, String email, String telefono) {
        String id = "U-" + UUID.randomUUID();
        String pwd = "1234"; // password por defecto (puedes cambiarlo luego)
        Usuario u = new Usuario(id, nombre, email, telefono, pwd, RolUsuario.CLIENTE);
        usuarioRepo.save(u);
        return toUsuarioDTO(u);
    }

    public void crearUsuario(String id, String nombre, String email, String telefono, String pass, RolUsuario rol) {
        Usuario u = new Usuario(id, nombre, email, telefono, pass, rol);
        usuarioRepo.save(u);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepo.findAll().stream().map(this::toUsuarioDTO).collect(Collectors.toList());
    }

    public void eliminarUsuario(String id) { usuarioRepo.delete(id); }

    // ----------------- REPARTIDORES -----------------
    public void crearRepartidor(String id, String nombre, String doc, String tel, DisponibilidadRepartidor disp, String zona) {
        Repartidor r = new Repartidor(id, nombre, doc, tel, disp, zona);
        repartidorRepo.save(r);
    }

    public List<RepartidorDTO> listarRepartidores() {
        return repartidorRepo.findAll().stream().map(this::toRepartidorDTO).collect(Collectors.toList());
    }

    public void eliminarRepartidor(String id) { repartidorRepo.delete(id); }

    // ----------------- ENVÍOS -----------------
    // versión usada por controllers: recibe alias de origen/destino y dimensiones
    public EnvioDTO crearEnvio(String idOrigen, String idDestino,
                               double peso, double alto, double ancho, double profundidad) {
        Direccion origen = new Direccion("O-" + UUID.randomUUID(), idOrigen, idOrigen, "Ciudad", "0,0");
        Direccion destino = new Direccion("D-" + UUID.randomUUID(), idDestino, idDestino, "Ciudad", "0,0");
        Paquete paquete = new Paquete(peso, alto, ancho, profundidad);

        String idEnvio = "E-" + UUID.randomUUID();
        Envio envio = new Envio(idEnvio, origen, destino, paquete);

        envio.setEstado(new SolicitadoState(envio));

        double costo = new TarifaBasicaStrategy().calcular(envio);
        envio.setCosto(costo);

        envioRepo.save(envio);

        return toEnvioDTO(envio);
    }

    // cotizar por objeto Direccion/Paquete y lista de servicios (usado en Main ejemplo)
    public EnvioDTO cotizarEnvio(Direccion origen, Direccion destino, Paquete paquete, List<String> servicios) {
        String idEnvio = "E-" + UUID.randomUUID();
        Envio envio = new Envio(idEnvio, origen, destino, paquete);
        // base con estrategia
        TarifaBasicaStrategy estrategia = new TarifaBasicaStrategy();
        double base = estrategia.calcular(envio);

        // Decoradores según servicios
        TarifaComponent componente = new TarifaBasicaComponent(envio);
        if (servicios != null) {
            for (String s : servicios) {
                if (s.equalsIgnoreCase(ServicioAdicional.SEGURO.name())) componente = new SeguroDecorator(componente);
                // agregar otros decoradores si se implementan
            }
        }
        double costo = componente.getCosto();
        envio.setCosto(costo);
        envio.setEstado(new SolicitadoState(envio));
        // no se guarda en repo: solo cotización
        return toEnvioDTO(envio);
    }

    public List<EnvioDTO> listarEnvios() {
        return envioRepo.findAll().stream().map(this::toEnvioDTO).collect(Collectors.toList());
    }

    public EnvioDTO buscarEnvio(String idEnvio) {
        return envioRepo.findById(idEnvio).map(this::toEnvioDTO).orElse(null);
    }

    public boolean asignarEnvio(String idEnvio, String idRepartidor) {
        Optional<Envio> eOpt = envioRepo.findById(idEnvio);
        Optional<Repartidor> rOpt = repartidorRepo.findById(idRepartidor);
        if (eOpt.isEmpty() || rOpt.isEmpty()) return false;
        Envio envio = eOpt.get();
        Repartidor rep = rOpt.get();
        try {
            envio.getEstado().asignar(envio, rep); // el State hace la transición
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ----------------- PAGO -----------------
    // procesa PagoDTO (ejemplo simple) y devuelve Pago (modelo)
    public Pago procesarPago(PagoDTO pagoDTO) {
        // Lógica simulada: aprobar si monto > 0
        Pago p = new Pago("P-" + UUID.randomUUID(), pagoDTO.getMonto(), pagoDTO.getMetodo());
        boolean aprobado = pagoDTO.getMonto() > 0;
        p.setResultado(aprobado ? ResultadoPago.APROBADO : ResultadoPago.RECHAZADO);
        return p;
    }

    // método que usan controllers: pagar por id de envío (simulado)
    public String pagarEnvio(String idEnvio) {
        Optional<Envio> opt = envioRepo.findById(idEnvio);
        if (opt.isEmpty()) return "Envío no encontrado";
        Envio e = opt.get();
        Pago p = new Pago("P-" + UUID.randomUUID(), e.getCosto(), "SIMULADO");
        p.setResultado(ResultadoPago.APROBADO);
        // no persiste pagos (no tienes repo), pero podrías añadirlo
        return "Pago aprobado por " + e.getCosto();
    }

    // ----------------- MÉTRICAS -----------------
    public Map<String, Integer> metricasPorZona() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Envio e : envioRepo.findAll()) {
            if (e.getRepartidor() != null) {
                String zona = e.getRepartidor().getZona();
                mapa.put(zona, mapa.getOrDefault(zona, 0) + 1);
            }
        }
        return mapa;
    }

    // ----------------- MAPPERS A DTO -----------------
    private UsuarioDTO toUsuarioDTO(Usuario u) {
        return new UsuarioDTO(u.getIdUsuario(), u.getNombre(), u.getEmail(), u.getTelefono(), u.getRol());
    }

    private RepartidorDTO toRepartidorDTO(Repartidor r) {
        return new RepartidorDTO(r.getIdRepartidor(), r.getNombre(), r.getTelefono(), r.getZona(), r.getDisponibilidad());
    }

    private EnvioDTO toEnvioDTO(Envio e) {
        EnvioDTO dto = new EnvioDTO();
        dto.id = e.getIdEnvio();
        dto.origen = e.getOrigen().getAlias();
        dto.destino = e.getDestino().getAlias();
        dto.costo = e.getCosto();
        dto.estado = e.getEstado() != null ? e.getEstado().getNombre() : "N/A";
        dto.fechaCreacion = e.getFechaCreacion();
        dto.idRepartidor = e.getRepartidor() != null ? e.getRepartidor().getIdRepartidor() : null;
        return dto;
    }

}
