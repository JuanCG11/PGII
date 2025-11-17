module co.edu.uniquindio.poo.proyectofinaluq {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.proyectofinaluq to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinaluq;
}