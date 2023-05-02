package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Eliminar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] discos = request.getParameterValues("disk");
        CarritoBean cb = CarritoBean.getInstance();
        for (String s : discos) {
            Articulo a = new Articulo(s, 0, 0);
            if (cb.getCarrito().contains(a)) cb.getCarrito().remove(a);
        }

        float precioTotal = 0;
        for (Articulo a : cb.getCarrito()) {
            precioTotal += a.getCantidad() * a.getPrecio();
        }

        cb.setPrecioTotal(precioTotal);

        request.setAttribute("carritoBean", cb);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        dispatcher.forward(request, response);
    }
}
