import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Carrito extends HttpServlet {
    private String returnPrice() {
        // Recuperamos informacion del precio del CD
        StringTokenizer t = new StringTokenizer(descripcionCD,"|");
        t.nextToken();
        t.nextToken();
        t.nextToken();
        precioString = t.nextToken();
        precioString = precioString.replace('$',' ').trim();
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println( "<HEAD></HEAD <BODY>\n" +
                "<H1>Carrito</H1>\n"
                );
    }
}
