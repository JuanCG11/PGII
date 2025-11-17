package co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.EnvioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.dto.UsuarioDTO;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.facade.LogisticsFacade;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.patterns.creacionales.singleton.AppConfig;
import co.edu.uniquindio.poo.proyectofinaluq.logistica.utils.SceneLoader;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import java.nio.file.Path;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HistorialEnviosController {
    @FXML
    private TableView<EnvioDTO> tablaHistorial;

    private final LogisticsFacade facade = new LogisticsFacade();

    @FXML
    public void initialize() {
        // mostramos todos los envíos (si quieres filtrar por usuario necesitas idUsuario en DTO)
        List<EnvioDTO> lista = facade.listarEnvios();
        tablaHistorial.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    public void onExportarCSV() {
        List<EnvioDTO> lista = facade.listarEnvios();
        if (lista.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("No hay envíos para exportar");
            a.show();
            return;
        }

        String fileName = "envios_" + System.currentTimeMillis() + ".csv";
        Path out = Path.of(System.getProperty("user.home")).resolve(fileName);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter w = Files.newBufferedWriter(out, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            // header
            w.write("id,origen,destino,costo,estado,fechaCreacion,idRepartidor");
            w.newLine();

            for (EnvioDTO e : lista) {
                String fecha = e.fechaCreacion != null ? e.fechaCreacion.format(df) : "";
                String line = String.format("%s,%s,%s,%.2f,%s,%s,%s",
                        safe(e.id), safe(e.origen), safe(e.destino), e.costo, safe(e.estado),
                        fecha, safe(e.idRepartidor));
                w.write(line);
                w.newLine();
            }
            w.flush();

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Exportado con éxito");
            a.setContentText("Archivo: " + out.toAbsolutePath());
            a.show();

        } catch (IOException io) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Error exportando CSV");
            a.setContentText(io.getMessage());
            a.show();
        }
    }

    private String safe(Object o) {
        return o == null ? "" : o.toString().replace(",", " ");
    }

    @FXML
    public void onVolver() {
        SceneLoader.load("usuarioView.fxml", "Panel Usuario");
    }
}
