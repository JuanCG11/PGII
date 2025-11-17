package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void onLogin() {
        String email = txtEmail.getText();
        String pass = txtPassword.getText();

        UsuarioDTO user = facade.login(email, pass);

        if (user == null) {
            showAlert("Error", "Credenciales inválidas");
            return;
        }

        // Navegación según el rol
        if (user.isAdmin()) {
            SceneLoader.load("adminView.fxml", "Panel Administrador");
        } else {
            SceneLoader.load("usuarioView.fxml", "Panel Usuario");
        }
    }

    @FXML
    public void onRegister() {
        SceneLoader.load("register.fxml", "Registro de Usuario");
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(title);
        a.setContentText(msg);
        a.show();
    }
}
