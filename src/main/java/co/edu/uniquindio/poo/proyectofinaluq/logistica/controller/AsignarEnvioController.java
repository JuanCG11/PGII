package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.RepartidorDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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
            System.out.println("Selecciona un envío y un repartidor");
            return;
        }

        boolean ok = facade.asignarEnvio(envio.id, rep.id());

        if (!ok) {
            System.out.println("No se pudo asignar el envío (Estado no permite asignación)");
        } else {
            System.out.println("Envío asignado correctamente");

            // refrescar tabla
            tablaEnvios.setItems(FXCollections.observableArrayList(facade.listarEnvios()));
        }
    }
}
