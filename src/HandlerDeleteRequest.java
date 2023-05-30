import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.sql.*;
import java.io.OutputStream;

public class HandlerDeleteRequest {

    private static Connection conn;
    private static String path;
    private static String tableName;
    private static String id;
    private static String[] pathSegments;
    private static int statusCode;
    private static String response;

    public static void handleDeleteRequest(HttpExchange exchange) throws SQLException, IOException {

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();

        // Memisahkan path menjadi endpoint dan id
        pathSegments = path.split("/");

        OutputStream outputStream = exchange.getResponseBody();

        if (pathSegments.length == 3) {
            tableName = pathSegments[1];
            id = pathSegments[2];
            if (tableName.equalsIgnoreCase("users")) {
                deleteData(tableName, "users", id);
            } else if (tableName.equalsIgnoreCase("products")) {
                deleteData(tableName, "id", id);
            } else if (tableName.equalsIgnoreCase("reviews")) {
                deleteData(tableName, "review_id", id);
            } else if (tableName.equalsIgnoreCase("addresses")) {
                deleteData(tableName, "id", id);
            } else if (tableName.equalsIgnoreCase("orders")) {
                deleteData(tableName, "id", id);
            } else if (tableName.equals("order_details")) {
                deleteData(tableName, "order_id", id);
            } else {
                response = "Path invalid.";
                statusCode = 400;
                exchange.sendResponseHeaders(statusCode, response.length());
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            response = "Delete berhasil";
            statusCode = 200;
            exchange.sendResponseHeaders(statusCode, response.length());
            outputStream.write(response.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    public static void deleteData(String tableName, String id, String columnId) {
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM " + tableName + " WHERE " + id + " = " + columnId;
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
