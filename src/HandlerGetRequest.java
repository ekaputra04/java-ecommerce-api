import com.sun.net.httpserver.HttpExchange;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class HandlerGetRequest {

    private static String tableName;
    private static String id;
    private static String path;
    private static String query;
    private static JSONArray data = new JSONArray();
    private static ResultSet resultSet;

    public static String handleGetRequest(HttpExchange exchange) throws SQLException {

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();
        // Memisahkan path menjadi endpoint dan id
        String[] pathSegments = path.split("/");
        // Menghubungkan ke database SQLite
        Connection conn = DatabaseConnection.getConnection();
        Statement statement = conn.createStatement();

        // Memastikan segment pertama adalah nama tabel
        if (pathSegments.length >= 2) {
            tableName = pathSegments[1];
        } else {
            // Jika tidak ada nama tabel, kembalikan respon error
            return "Invalid path. Please specify a table name.";
        }

        // Memeriksa apakah tabel valid
        if (!isValidTable(tableName)) {
            // Jika tabel tidak valid, kembalikan respon error
            return "Invalid table name.";
        }

        try {
            if (pathSegments.length == 3) {
                // Memastikan ada ID yang diberikan
                id = pathSegments[2];
                query = "SELECT * FROM " + tableName + " WHERE users = " + id;
            } else {
                // Jika tidak ada ID, ambil semua data dari tabel
                query = "SELECT * FROM " + tableName;
            }

            resultSet = statement.executeQuery(query);

            // Mengambil hasil query dan menyimpannya dalam JSONArray
            while (resultSet.next()) {
                JSONObject item = new JSONObject();
                if (tableName.equals("users")) {
                    item.put("users", resultSet.getInt("users"));
                    item.put("first_name", resultSet.getString("first_name"));
                    item.put("last_name", resultSet.getString("last_name"));
                    item.put("email", resultSet.getString("email"));
                    item.put("phone_number", resultSet.getString("phone_number"));
                    item.put("type", resultSet.getString("tipe"));
                } else if (tableName.equals("addresses")) {
                    item.put("users", resultSet.getInt("id"));
                    item.put("type", resultSet.getString("tipe"));
                    item.put("line1", resultSet.getString("line1"));
                    item.put("line2", resultSet.getString("line2"));
                    item.put("city", resultSet.getString("city"));
                    item.put("province", resultSet.getString("province"));
                    item.put("postcode", resultSet.getString("postcode"));
                } else if (tableName.equals("products")) {
                    item.put("id", resultSet.getInt("id"));
                    item.put("seller", resultSet.getInt("seller"));
                    item.put("title", resultSet.getString("title"));
                    item.put("description", resultSet.getString("description"));
                    item.put("price", resultSet.getString("price"));
                    item.put("stock", resultSet.getInt("stock"));
                } else if (tableName.equals("orders")) {
                    item.put("id", resultSet.getInt("id"));
                    item.put("buyer", resultSet.getInt("buyer"));
                    item.put("note", resultSet.getInt("note"));
                    item.put("total", resultSet.getInt("total"));
                    item.put("discount", resultSet.getInt("discount"));
                    item.put("is_paid", resultSet.getString("is_paid"));
                } else if (tableName.equals("reviews")) {
                    item.put("id", resultSet.getInt("review_id"));
                    item.put("star", resultSet.getInt("star"));
                    item.put("description", resultSet.getString("desciption"));
                    item.put("order_id", resultSet.getInt("order_id"));
                } else if (tableName.equals("order_details")) {
                    item.put("id", resultSet.getInt("order_id"));
                    item.put("product", resultSet.getInt("product"));
                    item.put("quantity", resultSet.getInt("quantity"));
                    item.put("price", resultSet.getInt("price"));
                }
                data.put(item);
            }

            // Menutup koneksi ke database
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Mengatur indentasi pada JSON
        String response = data.toString(2);
        return response;
    }

    private static boolean isValidTable(String tableName) {
        // Daftar tabel yang valid
        String[] validTables = {"users", "products", "orders"};

        // Memeriksa apakah tabel ada dalam daftar tabel yang valid
        for (String validTable : validTables) {
            if (validTable.equalsIgnoreCase(tableName)) {
                return true;
            }
        }

        return false;
    }
}
