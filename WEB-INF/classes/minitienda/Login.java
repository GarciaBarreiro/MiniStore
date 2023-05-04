package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parametros del formulario de inicio de sesion
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        
        //System.out.println(clave);
        //System.out.println(correo);

        // Establecer la conexion con la base de datos
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/carritoBD"; // URL de conexion de la base de datos
        Properties user = new Properties();
        user.setProperty("user", "postgres");
        user.setProperty("password", "0000");

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user);
        } catch (Exception e) {
            // Manejar errores de conexion
            e.printStackTrace();
            System.out.println("Error de conexion");
        }

        //System.out.println("valor de conexion: "+con);

        // Ejecutar una consulta en la base de datos
        String consulta = "SELECT correo FROM usuarios WHERE correo = ? AND clave = ?";
        //String consulta = "INSERT INTO usuarios (correo, clave) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            preparedStatement = con.prepareStatement(consulta);
            preparedStatement.setString(1, correo); // usuario es la variable que contiene el usuario del usuario
            preparedStatement.setString(2, clave);
            rs = preparedStatement.executeQuery();

            // Recorrer los resultados de la consulta
            if (rs.next()) {
                // Hay al menos un registro en el ResultSet
                if (rs.isLast()) {
                    // El usuario existe y es unico, iniciar sesion
                    request.getSession().setAttribute("correo", correo);
                    // Redirigir a la pagina de la request
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrito.jsp");
                    dispatcher.forward(request, response);
                } 
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                request.setAttribute("errorMessageLogin", "Nombre de usuario o contraseña incorrectos");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // Manejar errores de la consulta
            e.printStackTrace();
        } finally {
            // Cerrar los objetos ResultSet, PreparedStatement y Connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Manejar errores al cerrar los objetos
                e.printStackTrace();
            }
        }
    }
}
