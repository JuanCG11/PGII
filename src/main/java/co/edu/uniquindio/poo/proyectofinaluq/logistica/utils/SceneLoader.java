package co.edu.uniquindio.poo.proyectofinaluq.logistica.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void load(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneLoader.class.getResource("/co/edu/uniquindio/poo/proyectofinaluq/" + fxml)
            );

            Parent root = loader.load();
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
