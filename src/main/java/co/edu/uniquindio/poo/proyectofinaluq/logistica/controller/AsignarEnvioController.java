package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.RepartidorDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class AsignarEnvioController {
    @FXML
    private TableView<EnvioDTO> tablaEnvios;

    @FXML
    private ComboBox<RepartidorDTO> cmbRepartidor;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        tablaEnvios.setItems(FXCollections.observableArrayList(facade.listarEnvios()));
        cmbRepartidor.setItems(FXCollections.observableArrayList(facade.listarRepartidores()));
    }

    @FXML
    public void onAsignar() {

        EnvioDTO envio = tablaEnvios.getSelectionModel().getSelectedItem();
        RepartidorDTO rep = cmbRepartidor.getValue();

        if (envio == null || rep == null) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecciona envío y repartidor");
            a.show();
            return;
        }

        boolean ok = facade.asignarEnvio(envio.id, rep.id());

        Alert a = new Alert(ok ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        a.setHeaderText(ok ? "Asignado" : "No se pudo asignar");
        a.setContentText(ok ? "Envío asignado correctamente" : "El envío no pudo ser asignado (estado no permite asignación)");
        a.show();

        // refrescar tabla
        tablaEnvios.setItems(FXCollections.observableArrayList(facade.listarEnvios()));
    }
}
