import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class ini digunakan untuk menghubungkan program dengan database
 * Database yang digunakan berada dalam folder Sqlite dan bernama ecommerce.db
 */

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:Sqlite/ecommerce.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
