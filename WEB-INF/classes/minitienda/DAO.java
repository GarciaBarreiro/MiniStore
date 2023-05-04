package minitienda;

import java.sql.*;

public final class DAO {
    private Connection con;

    public DAO(Connection con) {
        this.con = con;
    }

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
            System.out.println("Exceptio: " + e.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println("Exceptio: " + e.getMessage());
            }
        }

        return exists;
    }
}
