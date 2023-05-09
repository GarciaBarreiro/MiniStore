package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Pagar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarritoBean cb = (CarritoBean) request.getSession().getAttribute("carritoBean");
        DataBaseFacade dbf = DataBaseFacade.getInstance();
        RequestDispatcher dispatcher;

        if (dbf.processPayment(request.getSession().getAttribute("correo").toString(), cb.getPrecioTotal())) {
            request.setAttribute("compra", cb.getCarrito().clone());
            request.setAttribute("total", cb.getPrecioTotal());
            dispatcher = getServletContext().getRequestDispatcher("/pago.jsp");
            cb.limpiarCarrito();
        } else {
            request.setAttribute("errorMessagePago", "Pago no completado.");
            dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        }

        dispatcher.forward(request, response);
    }
}
