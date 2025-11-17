module co.edu.uniquindio.poo.proyectofinaluq {
    requires javafx.controls;
    requires javafx.fxml;
    requires co.edu.uniquindio.poo.proyectofinaluq;


    opens co.edu.uniquindio.poo.proyectofinaluq to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinaluq;
}