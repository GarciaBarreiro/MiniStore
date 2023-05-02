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

    public void updateCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        final Articulo other = (Articulo) o;
        if (!this.nombre.equals(other.getNombre())) return false;

        return true;
    }
}
