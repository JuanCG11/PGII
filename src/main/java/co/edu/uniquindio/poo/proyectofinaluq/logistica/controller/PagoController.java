package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class PagoController {
    @FXML
    private TableView<EnvioDTO> tablaEnvios;

    @FXML
    private Label lblResultado;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        tablaEnvios.setItems(FXCollections.observableArrayList(facade.listarEnvios()));
    }

    @FXML
    public void onPagar() {
        EnvioDTO envio = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envio != null) {
            String result = facade.pagarEnvio(envio.id());
            lblResultado.setText(result);
        }
    }
}
