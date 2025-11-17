package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
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

        UsuarioDTO user = facade.loginUsuario(email, pass);

        if (user == null) {
            showAlert();
            return;
        }

        if (user.rol() == RolUsuario.ADMIN) {
            SceneLoader.load("adminView.fxml", "Panel Administrador");
        } else {
            SceneLoader.load("usuarioView.fxml", "Panel Usuario");
        }
    }

    @FXML
    public void onRegister() {
        SceneLoader.load("register.fxml", "Registro de Usuario");
    }

    private void showAlert() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("Error");
        a.setContentText("Credenciales inválidas");
        a.show();
    }
}
