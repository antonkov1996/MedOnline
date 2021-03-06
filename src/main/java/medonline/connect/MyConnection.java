package medonline.connect;

import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return MySQLConnect.getMySQLConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }

}
