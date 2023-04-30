package minitienda;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Carrito extends HttpServlet {

    private ArrayList<Articulo> carrito = new ArrayList<>(); // lista de artículos en el carrito


    private float returnPrice(String descripcionCD) {
        // Recuperamos informacion del precio del CD
        String precioStr = null;

        StringTokenizer t = new StringTokenizer(descripcionCD, "|");
        t.nextToken();
        t.nextToken();
        t.nextToken();
        precioStr = t.nextToken();
        precioStr = precioStr.replace('$',' ').trim();
        
        if(precioStr != null) {
            return Float.parseFloat(precioStr);
        } else {
            return 0;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        // obtener los parámetros de la solicitud
        float precio = returnPrice(request.getParameter("articuloSeleccionado"));
        String nombre = request.getParameter("articuloSeleccionado");
        String cantidadStr = request.getParameter("cantidad");
        Integer cantidad = Integer.parseInt(cantidadStr);

        CarritoBean carritoBean = new CarritoBean();

        // si se recibieron valores válidos de nombre y precio, agregar el artículo al
        // carrito
        if (nombre != null && cantidad > 0) {
            Articulo nuevoArticulo = new Articulo(nombre, precio, cantidad);
            carrito.add(nuevoArticulo);
        }

        // calcular el precio total del carrito
        float precioTotal = 0.0f;
        for (Articulo a : carrito) {
            precioTotal += a.getCantidad()*a.getPrecio();
        }
    
        carritoBean.setPrecioTotal(precioTotal);
        carritoBean.setCarrito(carrito);

        request.setAttribute("carritoBean", carritoBean);
    
        // Obtener el objeto RequestDispatcher y enviar la solicitud al JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        dispatcher.forward(request, response);
    }
}
