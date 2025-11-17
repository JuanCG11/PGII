package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
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

            double peso = Double.parseDouble(txtPeso.getText().trim());
            double alto = Double.parseDouble(txtAlto.getText().trim());
            double ancho = Double.parseDouble(txtAncho.getText().trim());
            double prof = Double.parseDouble(txtProfundidad.getText().trim());

            EnvioDTO dto = facade.crearEnvio(
                    cmbOrigen.getValue(),
                    cmbDestino.getValue(),
                    peso,
                    alto,
                    ancho,
                    prof
            );

            lblResultado.setText("✔ Envío creado ID: " + dto.id + "\nCosto: $" + dto.costo);

        } catch (NumberFormatException nfe) {
            lblResultado.setText(" Error: ingresa valores numéricos válidos.");
        } catch (Exception e) {
            lblResultado.setText(" Error inesperado: " + e.getMessage());
        }
    }
}
