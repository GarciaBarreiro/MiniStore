package minitienda;

public class Articulo {

    private String nombre;
    private float precio = 0.00f;
    private int cantidad;

    public Articulo(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}