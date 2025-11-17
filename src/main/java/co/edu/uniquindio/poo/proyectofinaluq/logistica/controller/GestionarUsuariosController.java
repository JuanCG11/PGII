package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionarUsuariosController {

    @FXML
    private TableView<UsuarioDTO> tablaUsuarios;

    @FXML
    private TextField txtNombre, txtEmail, txtTelefono;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        tablaUsuarios.setItems(FXCollections.observableArrayList(facade.listarUsuarios()));
    }

    @FXML
    public void onCrear() {
        facade.crearUsuario(
                txtNombre.getText(),
                txtEmail.getText(),
                txtTelefono.getText()
        );
        refresh();
    }

    @FXML
    public void onEliminar() {
        UsuarioDTO selected = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (selected != null) {
            facade.eliminarUsuario(selected.id());
            refresh();
        }
    }

    private void refresh() {
        tablaUsuarios.setItems(
                FXCollections.observableArrayList(facade.listarUsuarios())
        );
    }
}
