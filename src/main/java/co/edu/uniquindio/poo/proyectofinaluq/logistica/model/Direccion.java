package co.edu.uniquindio.poo.proyectofinaluq.logistica.model;

public class Direccion {
    private final String idDireccion;
    private String alias;
    private final String calle;
    private final String ciudad;
    private final String coordenadas; // cadena simulada "lat,lng"

    public Direccion(String id, String alias, String calle, String ciudad, String coordenadas) {
        this.idDireccion = id; this.alias = alias; this.calle = calle; this.ciudad = ciudad; this.coordenadas = coordenadas;
    }

    public String getIdDireccion() { return idDireccion; }
    public String getAlias() { return alias; }
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCoordenadas() { return coordenadas; }
    public void setAlias(String alias) { this.alias = alias; }
}
