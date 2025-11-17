package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

public class Paquete {
    private final double peso; // kg
    private final double alto; // cm
    private final double ancho;
    private final double profundidad;

    public Paquete(double peso, double alto, double ancho, double profundidad) {
        this.peso = peso; this.alto = alto; this.ancho = ancho; this.profundidad = profundidad;
    }

    public double getPeso() { return peso; }
    public double getAlto() { return alto; }
    public double getAncho() { return ancho; }
    public double getProfundidad() { return profundidad; }
    public double getVolumen() { return (alto * ancho * profundidad) / 1000.0; } // ejemplo litros
}
