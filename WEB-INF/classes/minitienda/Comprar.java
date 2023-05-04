package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Comprar extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        if (request.getSession().getAttribute("correo") != null) {
            // El usuario ha iniciado sesión, enviar a un servlet que procese la compra
            dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        } else {
            // El usuario no ha iniciado sesión, se le pide que inicie sesión o se registre
            dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        }
        dispatcher.forward(request, response);
    }
}
