package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import javafx.fxml.FXML;

public class AdminViewController {
    @FXML
    public void onGestionUsuarios() {
        SceneLoader.load("gestionarUsuarios.fxml", "Gestionar Usuarios");
    }

    @FXML
    public void onGestionRepartidores() {
        SceneLoader.load("gestionarRepartidores.fxml", "Gestionar Repartidores");
    }

    @FXML
    public void onAsignarEnvio() {
        SceneLoader.load("asignarEnvio.fxml", "Asignar Envíos");
    }

    @FXML
    public void onMetricas() {
        SceneLoader.load("metricas.fxml", "Métricas del Sistema");
    }

    @FXML
    public void onSalir() {
        SceneLoader.load("login.fxml", "Login");
    }
}
