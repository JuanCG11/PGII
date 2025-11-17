package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class MetricasController {

    @FXML
    private BarChart<String, Number> barChart;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Envíos por zona");

        facade.metricasPorZona().forEach((zona, cantidad) -> {
            serie.getData().add(new XYChart.Data<>(zona, cantidad));
        });

        barChart.getData().add(serie);
    }
}
