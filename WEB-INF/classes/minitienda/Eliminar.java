package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Eliminar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] discos = request.getParameterValues("disk");
        CarritoBean cb = CarritoBean.getInstance();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        if (discos != null) {
            for (String s : discos) {
                Articulo a = new Articulo(s, 0, 0);
                if (cb.getCarrito().contains(a)) cb.getCarrito().remove(a);
            }
        }

        request.setAttribute("carritoBean", cb);

        dispatcher.forward(request, response);
    }
}
