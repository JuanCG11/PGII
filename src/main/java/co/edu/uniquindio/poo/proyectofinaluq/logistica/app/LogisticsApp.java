package co.edu.uniquindio.poo.proyectofinaluq.logistica.app;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.EnvioRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.RepartidorRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.repository.UsuarioRepository;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.service.PaymentService;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.service.ReportService;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.service.TarifaService;

public class LogisticsApp {
    private static volatile LogisticsApp instance;
    private final UsuarioRepository usuarioRepo;
    private final RepartidorRepository repartidorRepo;
    private final EnvioRepository envioRepo;
    private final TarifaService tarifaService;
    private final PaymentService paymentService;
    private final ReportService reportService;

    private LogisticsApp() {
        this.usuarioRepo = new UsuarioRepository();
        this.repartidorRepo = new RepartidorRepository();
        this.envioRepo = new EnvioRepository();
        this.tarifaService = new TarifaService();
        this.paymentService = new PaymentService();
        this.reportService = new ReportService();
        DataSeeder.seed(usuarioRepo, repartidorRepo, envioRepo);
    }

    public static LogisticsApp getInstance() {
        if (instance == null) {
            synchronized (LogisticsApp.class) {
                if (instance == null) instance = new LogisticsApp();
            }
        }
        return instance;
    }

    public UsuarioRepository getUsuarioRepo() { return usuarioRepo; }
    public RepartidorRepository getRepartidorRepo() { return repartidorRepo; }
    public EnvioRepository getEnvioRepo() { return envioRepo; }
    public TarifaService getTarifaService() { return tarifaService; }
    public PaymentService getPaymentService() { return paymentService; }
    public ReportService getReportService() { return reportService; }
}
