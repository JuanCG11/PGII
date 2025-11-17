package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
import javafx.fxml.FXML;

public class UsuarioViewController {
    @FXML
    public void onCrearEnvio() {
        SceneLoader.load("crearEnvio.fxml", "Crear Envío");
    }

    @FXML
    public void onCotizarEnvio() {
        SceneLoader.load("cotizarEnvio.fxml", "Cotizar Envío");
    }

    @FXML
    public void onHistorial() {
        SceneLoader.load("historialEnvios.fxml", "Historial de Envíos");
    }

    @FXML
    public void onPago() {
        SceneLoader.load("pago.fxml", "Pagos");
    }

    @FXML
    public void onSalir() {
        SceneLoader.load("login.fxml", "Login");
    }
}
