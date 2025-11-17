package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.UUID;

public class RegisterController {
    @FXML
    private TextField txtNombre, txtEmail, txtTelefono;

    @FXML
    private PasswordField txtPassword;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void onRegistrar() {

        String id = "U-" + UUID.randomUUID();

        facade.crearUsuario(
                id,
                txtNombre.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtPassword.getText(),
                RolUsuario.CLIENTE
        );

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Registro exitoso");
        a.setContentText("Usuario creado correctamente.");
        a.show();

        SceneLoader.load("login.fxml", "Login");
    }

    @FXML
    public void onVolver() {
        SceneLoader.load("login.fxml", "Login");
    }
}
