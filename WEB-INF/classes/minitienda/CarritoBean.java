package minitienda;

import java.util.ArrayList;

public class CarritoBean {
    private ArrayList<Articulo> carrito = new ArrayList<Articulo>();
    private float precioTotal = 0.00f;

    public CarritoBean (){
        
    }

    public void setCarrito(ArrayList<Articulo> carrito) {
        this.carrito = carrito;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;

    }
    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
}