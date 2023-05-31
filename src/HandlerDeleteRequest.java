import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.sql.*;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class `HandlerDeleteRequest` menangani permintaan HTTP dengan metode DELETE.
 */

public class HandlerDeleteRequest {
    private static Connection conn;
    private static String path;
    private static String tableName;
    private static String id;
    private static String response;
    private static String[] pathSegments;
    private static int statusCode;
    private static JSONArray data = new JSONArray();

    public static void handleDeleteRequest(HttpExchange exchange) throws SQLException, IOException {
        // Mendapatkan OutputStream dari ResponseBody pada objek `exchange`
        OutputStream outputStream = exchange.getResponseBody();
        JSONObject jsonObject = new JSONObject();

        try {
            // Menghapus data pada JSONArray untuk menghindari duplikasi data
            data.clear();

            // Mendapatkan path dari permintaan
            path = exchange.getRequestURI().getPath();

            // Memisahkan path menjadi endpoint dan id
            pathSegments = path.split("/");

            if (pathSegments.length == 3) {
                tableName = pathSegments[1];
                id = pathSegments[2];
                if (tableName.equalsIgnoreCase("users")) {
                    deleteData(tableName, "users", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else if (tableName.equalsIgnoreCase("products")) {
                    deleteData(tableName, "id", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else if (tableName.equalsIgnoreCase("reviews")) {
                    deleteData(tableName, "review_id", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else if (tableName.equalsIgnoreCase("addresses")) {
                    deleteData(tableName, "id", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else if (tableName.equalsIgnoreCase("orders")) {
                    deleteData(tableName, "id", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else if (tableName.equals("order_details")) {
                    deleteData(tableName, "order_id", id);
                    jsonObject = Fitur.deleteDataSuccess(tableName, id);
                } else {
                    jsonObject = Fitur.unvaliableTable(tableName);
                }
            } else {
                jsonObject = Fitur.invalidPath(exchange);
            }

            data.put(jsonObject);
            statusCode = jsonObject.getInt("status_code");
            response = data.toString(2);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            outputStream.write(response.getBytes());
            outputStream.flush();
            outputStream.close();
        } finally {
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
