package minitienda;

import java.sql.*;
import java.util.*;

public final class DataBaseFacade {
    private static DataBaseFacade instance = new DataBaseFacade();
    private DAO dao;

    private DataBaseFacade() {
        try {
            Connection con = null;
            String url = "jdbc:postgresql://localhost:5432/carritoBD";
            Properties user = new Properties();
            user.setProperty("user", "postgres");
            user.setProperty("password", "0000");

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user);
            
            dao = new DAO(con);
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public static DataBaseFacade getInstance() {
        return instance;
    }

    public boolean userExists(String correo, String clave) {
        return dao.userExists(correo, clave);
    }

    public boolean signUpUser(String correo, String clave) {
        return dao.signUpUser(correo, clave);
    }

    public boolean processPayment(String correo, float total) {
        return dao.processPayment(correo, total);
    }
}
