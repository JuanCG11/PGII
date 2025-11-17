package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CrearEnvioController {
    @FXML
    private TextField txtPeso, txtAlto, txtAncho, txtLargo;

    @FXML
    private ComboBox<String> cmbOrigen, cmbDestino;

    @FXML
    private Label lblResultado;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void onCrearEnvio() {
        EnvioDTO dto = facade.crearEnvio(
                cmbOrigen.getValue(),
                cmbDestino.getValue(),
                Double.parseDouble(txtPeso.getText()),
                Double.parseDouble(txtAlto.getText()),
                Double.parseDouble(txtAncho.getText()),
                Double.parseDouble(txtLargo.getText())
        );

        lblResultado.setText("Envío creado: ID " + dto.id());
    }
}
