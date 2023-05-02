package minitienda;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class Comprar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("correo") != null) {
            // El usuario ha iniciado sesión, se puede proceder con la compra
            response.sendRedirect("pagina-de-compra.jsp");
        } else {
            // El usuario no ha iniciado sesión, se le pide que inicie sesión o se registre
            response.sendRedirect("pagina-de-inicio-de-sesion-o-registro.jsp");
        }
    }
}