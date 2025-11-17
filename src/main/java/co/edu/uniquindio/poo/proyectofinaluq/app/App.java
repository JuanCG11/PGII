package co.edu.uniquindio.poo.proyectofinaluq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/poo/proyectofinaluq/login.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Plataforma Logística UQ");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // <-- ESTA es la ejecución real de la interfaz
    }
}
