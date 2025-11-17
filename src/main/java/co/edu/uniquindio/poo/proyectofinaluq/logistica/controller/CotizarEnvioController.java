package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.model.Paquete;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CotizarEnvioController {
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
    public void onCotizar() {
        try {
            // Construir un paquete
            Paquete p = new Paquete(
                    Double.parseDouble(txtPeso.getText()),
                    Double.parseDouble(txtAlto.getText()),
                    Double.parseDouble(txtAncho.getText()),
                    Double.parseDouble(txtProfundidad.getText())
            );

            double costo = 5000
                    + p.getPeso() * 1000
                    + p.getVolumen() * 50;

            lblResultado.setText("Costo estimado: $" + costo);

        } catch (Exception e) {
            lblResultado.setText("Error: datos inválidos.");
        }
    }

    @FXML
    public void onVolver() {
        SceneLoader.load("usuarioView.fxml", "Panel Usuario");
    }
}
