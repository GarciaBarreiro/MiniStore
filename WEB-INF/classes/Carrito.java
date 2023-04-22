import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Carrito extends HttpServlet {

    private ArrayList<Articulo> carrito = new ArrayList<>(); // lista de artículos en el carrito

    private float returnPrice(String descripcionCD) {
        // Recuperamos informacion del precio del CD
        String precioStr = null;

        StringTokenizer t = new StringTokenizer(descripcionCD, "|");
        t.nextToken();
        t.nextToken();
        t.nextToken();
        precioStr = t.nextToken();
        precioStr = precioStr.replace('$',' ').trim();
        
        if(precioStr != null) {
            return Float.parseFloat(precioStr);
        } else {
            return 0;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // obtener los parámetros de la solicitud
        float precio = returnPrice(request.getParameter("articuloSeleccionado"));
        String nombre = request.getParameter("articuloSeleccionado");
        String cantidadStr = request.getParameter("cantidad");
        Integer cantidad = Integer.parseInt(cantidadStr);

        // si se recibieron valores válidos de nombre y precio, agregar el artículo al
        // carrito
        if (nombre != null && cantidad > 0) {
            Articulo nuevoArticulo = new Articulo(nombre, precio, cantidad);
            carrito.add(nuevoArticulo);
        }

        // calcular el precio total del carrito
        float precioTotal = 0.0f;
        for (Articulo a : carrito) {
            precioTotal += a.getCantidad()*a.getPrecio();
        }

        // generar la respuesta HTML
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Carrito de Compra</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Carrito de Compra</h1>\n" +
                "<table>\n" +
                "<tr>\n" +
                "<th>Articulo</th>\n" +
                "<th>Cantidad</th>\n" +
                "<th>Precio</th>\n" +
                "</tr>\n");

        // mostrar los artículos del carrito
        for (Articulo a : carrito) {
            out.println("<tr>\n" +
                    "<td>" + a.getNombre() + "</td>\n" +
                    "<td>" + a.getCantidad() + "</td>\n" +
                    "<td>" + String.format("%.2f", a.getPrecio()) + "</td>\n" +
                    "</tr>\n");
        }

        out.println("</table>");
        out.println("<div>\n" +
                    "<h2>Precio total:" + String.format("%.2f", precioTotal) + "</h2>\n");
    }

    private class Articulo {

        private String nombre;
        private float precio;
        private int cantidad;

        public Articulo(String nombre, float precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidad() {
            return cantidad;
        }
    }
}
