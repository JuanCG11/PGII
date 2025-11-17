module co.edu.uniquindio.poo.proyectofinaluq {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens co.edu.uniquindio.poo.proyectofinaluq.logistica.controller to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinaluq.logistica.controller;

    opens co.edu.uniquindio.poo.proyectofinaluq.app to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinaluq.app;

    opens co.edu.uniquindio.poo.proyectofinaluq to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinaluq;

}