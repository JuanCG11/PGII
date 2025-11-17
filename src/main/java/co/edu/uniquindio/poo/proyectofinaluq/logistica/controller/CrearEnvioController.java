package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CrearEnvioController {
    @FXML
    private TextField txtPeso, txtAlto, txtAncho, txtProfundidad;

    @FXML
    private ComboBox<String> cmbOrigen, cmbDestino;

    @FXML
    private Label lblResultado;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        cmbOrigen.getItems().addAll("Casa", "Oficina", "Apartamento");
        cmbDestino.getItems().addAll("Casa", "Oficina", "Apartamento");
    }

    @FXML
    public void onCrearEnvio() {
        try {

            if (cmbOrigen.getValue() == null || cmbDestino.getValue() == null) {
                lblResultado.setText("Debes seleccionar origen y destino.");
                return;
            }

            EnvioDTO dto = facade.crearEnvio(
                    cmbOrigen.getValue(),
                    cmbDestino.getValue(),
                    Double.parseDouble(txtPeso.getText()),
                    Double.parseDouble(txtAlto.getText()),
                    Double.parseDouble(txtAncho.getText()),
                    Double.parseDouble(txtProfundidad.getText())
            );

            lblResultado.setText(
                    "✔ Envío creado con ID: " + dto.id +
                            "\nCosto: $" + dto.costo
            );

        } catch (Exception e) {
            lblResultado.setText("Error: verifica los datos del formulario.");
        }
    }
}
