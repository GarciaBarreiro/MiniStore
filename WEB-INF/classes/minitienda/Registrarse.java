package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class Registrarse extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parametros del formulario de registro
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        DataBaseFacade dbf = DataBaseFacade.getInstance();

        RequestDispatcher dispatcher;
        if (dbf.signUpUser(correo, clave)) {
            // Iniciar sesion
            request.getSession().setAttribute("correo", correo);
            // Redirigir a la pagina de la request
            dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/registrarse.jsp");
            request.setAttribute("errorMessageRegistro", "El usuario ya existe");
        }

        dispatcher.forward(request, response);
    }
}
