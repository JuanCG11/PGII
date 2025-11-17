package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.RolUsuario;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.UUID;

public class GestionarUsuariosController {
    @FXML
    private TableView<UsuarioDTO> tablaUsuarios;

    @FXML
    private TextField txtNombre, txtEmail, txtTelefono, txtPassword;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        refresh();
    }

    @FXML
    public void onCrear() {
        facade.crearUsuario(
                "U-" + UUID.randomUUID(),
                txtNombre.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtPassword.getText(),
                RolUsuario.CLIENTE
        );
        refresh();
    }

    @FXML
    public void onEliminar() {
        UsuarioDTO u = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (u != null) {
            facade.eliminarUsuario(u.id());
            refresh();
        }
    }

    private void refresh() {
        tablaUsuarios.setItems(FXCollections.observableArrayList(facade.listarUsuarios()));
    }
    @FXML
    public void onVolver() {
        SceneLoader.load("adminView.fxml", "Panel Administrador");
    }
}
