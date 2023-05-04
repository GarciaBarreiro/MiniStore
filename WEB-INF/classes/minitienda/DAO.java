package minitienda;

import java.sql.*;

public final class DAO {
    private Connection con;

    public DAO(Connection con) {
        this.con = con;
    }

    // returns true if user exists
    // else false
    public boolean userExists(String correo, String clave) {
        boolean exists = false;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = this.con.prepareStatement("SELECT correo FROM usuarios WHERE correo = ? AND clave = ?");
            ps.setString(1, correo);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            exists = rs.next();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        return exists;
    }

    // returns true if it was possible to sign up user
    // else false
    public boolean signUpUser(String correo, String clave) {
        int ret = 0;
        PreparedStatement ps = null;

        try {
            ps = this.con.prepareStatement("INSERT INTO usuarios (correo, clave) VALUES (?, ?)");
            ps.setString(1, correo);
            ps.setString(2, clave);

            ret = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        return ret != 0;
    }
}
