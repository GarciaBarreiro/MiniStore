package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Pagar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarritoBean cb = CarritoBean.getInstance();
        DataBaseFacade dbf = DataBaseFacade.getInstance();
        RequestDispatcher dispatcher;

        System.out.println("hasta aqui llega");

        Object correo = request.getSession().getAttribute("correo");

        System.out.println(correo.toString());

        if (dbf.processPayment(correo.toString(), cb.getPrecioTotal())) {
            request.setAttribute("errorMessageLogin", "Pago aceptado :)");
            cb.limpiarCarrito();
            dispatcher = getServletContext().getRequestDispatcher("/index.html");
        } else {
            request.setAttribute("errorMessageLogin", "Pago no aceptado :(");
            dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        }

        dispatcher.forward(request, response);
    }
}
