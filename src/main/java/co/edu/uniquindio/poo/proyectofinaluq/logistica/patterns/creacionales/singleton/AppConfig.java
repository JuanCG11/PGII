package co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.singleton;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;

public class AppConfig {
    private static AppConfig instance;

    private String appName = "Plataforma Logística UQ";
    private String version = "1.0.0";

    private UsuarioDTO usuarioActual;

    // Parámetros globales de tarifa
    private double costoBase = 5000;
    private double multiplicadorPeso = 1000;
    private double multiplicadorVolumen = 50;

    private AppConfig() {
        // privado para evitar instanciación
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // ==========================
    // GETTERS & SETTERS
    // ==========================

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public UsuarioDTO getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(UsuarioDTO usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getMultiplicadorPeso() {
        return multiplicadorPeso;
    }

    public void setMultiplicadorPeso(double multiplicadorPeso) {
        this.multiplicadorPeso = multiplicadorPeso;
    }

    public double getMultiplicadorVolumen() {
        return multiplicadorVolumen;
    }

    public void setMultiplicadorVolumen(double multiplicadorVolumen) {
        this.multiplicadorVolumen = multiplicadorVolumen;
    }
}
