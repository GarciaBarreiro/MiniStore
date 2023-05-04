package minitienda;

import java.util.ArrayList;

public final class CarritoBean {
    private ArrayList<Articulo> carrito = new ArrayList<Articulo>();
    private static CarritoBean instance = new CarritoBean();

    private CarritoBean (){
        
    }

    public static CarritoBean getInstance() {
        return instance;
    }

    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    public float getPrecioTotal() {
        float precioTotal = 0;
        for (Articulo a : this.carrito) {
            precioTotal += a.getCantidad() * a.getPrecio();
        }
        return precioTotal;
    }
}
