package minitienda;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String clave = request.getParameter("contraseña");

        // Establecer la conexión con la base de datos
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/carritoBD"; // URL de conexión de la base de datos
        String user = "postgres"; // Nombre de usuario de la base de datos
        String password = "0000"; // Contraseña de la base de datos

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Manejar errores de conexión
            e.printStackTrace();
        }

        // Imprimir la variable con
        System.out.println("aaa"+con);

        // Ejecutar una consulta en la base de datos
        String consulta = "SELECT correo FROM usuarios WHERE correo = ? AND clave = ?";
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
                    // Es el último registro en el ResultSet
                    // Iniciar sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("correo", correo);
                    // Redirigir a la página principal
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
                    dispatcher.forward(request, response);
                } 
            } else {
                // No se encontró ningún registro en el ResultSet
                // Redirigir a la página de inicio de sesión
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
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
