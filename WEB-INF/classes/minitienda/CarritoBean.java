package minitienda;

import java.util.ArrayList;
import java.io.Serializable;

public class CarritoBean implements Serializable {
    private ArrayList<Articulo> carrito = new ArrayList<Articulo>();

    public CarritoBean() {
        
    }

    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Articulo> carrito) {
        this.carrito = carrito;
    }

    public float getPrecioTotal() {
        float precioTotal = 0;
        for (Articulo a : this.carrito) {
            precioTotal += a.getCantidad() * a.getPrecio();
        }
        return precioTotal;
    }

    public void limpiarCarrito() {
        carrito.clear();
    }
}
