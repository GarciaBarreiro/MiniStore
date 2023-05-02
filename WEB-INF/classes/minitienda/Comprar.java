package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Comprar extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getSession().getAttribute("correo") != null) {
            // El usuario ha iniciado sesión, se puede proceder con la compra

            // Enviar a un servlet que procese la compra

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            // El usuario no ha iniciado sesión, se le pide que inicie sesión o se registre
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    
    }
}