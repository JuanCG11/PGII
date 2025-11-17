package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.RepartidorDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.enums.DisponibilidadRepartidor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionarRepartidoresController {
    @FXML
    private TableView<RepartidorDTO> tabla;

    @FXML
    private TextField txtId, txtNombre, txtDocumento, txtTelefono, txtZona;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        tabla.setItems(FXCollections.observableArrayList(facade.listarRepartidores()));
    }

    @FXML
    public void onCrear() {
        facade.crearRepartidor(
                txtId.getText(),
                txtNombre.getText(),
                txtDocumento.getText(),
                txtTelefono.getText(),
                DisponibilidadRepartidor.ACTIVO,
                txtZona.getText()
        );
        refresh();
    }

    @FXML
    public void onEliminar() {
        RepartidorDTO r = tabla.getSelectionModel().getSelectedItem();
        if (r != null) {
            facade.eliminarRepartidor(r.id());
            refresh();
        }
    }

    private void refresh() {
        tabla.setItems(FXCollections.observableArrayList(facade.listarRepartidores()));
    }
}