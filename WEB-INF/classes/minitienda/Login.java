package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parametros del formulario de inicio de sesion
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        
        DataBaseFacade dbf = DataBaseFacade.getInstance();

        RequestDispatcher dispatcher;
        if (dbf.userExists(correo, clave)) {
            request.getSession().setAttribute("correo", correo);
            dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            request.setAttribute("errorMessageLogin", "Nombre de usuario o contraseña incorrectos");
        }

        dispatcher.forward(request, response);
    }
}
