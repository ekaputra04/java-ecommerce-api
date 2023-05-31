import com.sun.net.httpserver.HttpExchange;
import java.sql.*;
import org.json.JSONArray;

/**
 * Class `HandlerGetRequest` menangani permintaan HTTP dengan metode GET.
 */

public class HandlerGetRequest {
    private static String tableName;
    private static String id;
    private static String path;
    private static String query;
    private static String response;
    private static String[] pathSegments;
    private static JSONArray data = new JSONArray();
    private static ResultSet resultSet;
    private static Connection conn;
    private static Statement statement;

    public static String handleGetRequest(HttpExchange exchange) throws SQLException {
        try {
            // Menghapus data pada JSONArray untuk menghindari duplikasi data
            data.clear();

            // Mendapatkan path dari permintaan
            path = exchange.getRequestURI().getPath();

            // Memisahkan path menjadi endpoint dan id
            pathSegments = path.split("/");

            // Mendapatkan query string dari permintaan
            query = exchange.getRequestURI().getQuery();

            // Menghubungkan ke database SQLite
            conn = DatabaseConnection.getConnection();
            statement = conn.createStatement();

            // Memastikan segment pertama adalah nama tabel
            if (pathSegments.length == 2) {
                tableName = pathSegments[1];
                if (query == null) {
                    query = "SELECT * FROM " + tableName;
                } else {
                    query = "SELECT * FROM " + tableName + " WHERE " + query;
                }
            } else if (pathSegments.length == 3) {
                tableName = pathSegments[1];
                id = pathSegments[2];
                if (tableName.equalsIgnoreCase("users")) {
                    query = "SELECT * FROM " + tableName + " WHERE users = " + id;
                } else if (tableName.equalsIgnoreCase("orders") || tableName.equalsIgnoreCase("products")
                        || tableName.equalsIgnoreCase("addresses")) {
                    query = "SELECT * FROM " + tableName + " WHERE id = " + id;
                } else if (tableName.equalsIgnoreCase("order_details")) {
                    query = "SELECT * FROM " + tableName + " WHERE order_id = " + id;
                } else if (tableName.equalsIgnoreCase("reviews")) {
                    query = "SELECT * FROM " + tableName + " WHERE review_id = " + id;
                }
            } else {
                // Jika tidak ada nama tabel, kembalikan respon error
                data.put(Fitur.unvaliableTable(tableName));
            }

            // Memeriksa apakah tabel valid
            if (!Fitur.isValidTable(tableName)) {
                // Jika tabel tidak valid, kembalikan respon error
                data.put(Fitur.unvaliableTable(tableName));
            }

            resultSet = statement.executeQuery(query);

            // Mengambil hasil query dan menyimpannya dalam JSONArray
            while (resultSet.next()) {
                if (tableName.equals("users")) {
                    Users users = new Users();
                    users.setId(resultSet.getInt("users"));
                    users.setFirstName(resultSet.getString("first_name"));
                    users.setLastName(resultSet.getString("last_name"));
                    users.setEmail(resultSet.getString("email"));
                    users.setPhoneNumber(resultSet.getString("phone_number"));
                    users.setType(resultSet.getString("tipe"));
                    data.put(users.toJsonObject());
                } else if (tableName.equals("addresses")) {
                    Addresses addresses = new Addresses();
                    addresses.setUsers(resultSet.getInt("id"));
                    addresses.setType(resultSet.getString("tipe"));
                    addresses.setLine1(resultSet.getString("line1"));
                    addresses.setLine2(resultSet.getString("line2"));
                    addresses.setCity(resultSet.getString("city"));
                    addresses.setProvince(resultSet.getString("province"));
                    addresses.setPostcode(resultSet.getString("postcode"));
                    data.put(addresses.toJsonObject());
                } else if (tableName.equals("products")) {
                    Products products = new Products();
                    products.setId(resultSet.getInt("id"));
                    products.setSeller(resultSet.getInt("seller"));
                    products.setTitle(resultSet.getString("title"));
                    products.setDescription(resultSet.getString("description"));
                    products.setPrice(resultSet.getString("price"));
                    products.setStock(resultSet.getInt("stock"));
                    data.put(products.toJsonObject());
                } else if (tableName.equals("orders")) {
                    Orders orders = new Orders();
                    orders.setId(resultSet.getInt("id"));
                    orders.setBuyer(resultSet.getInt("buyer"));
                    orders.setNote(resultSet.getInt("note"));
                    orders.setTotal(resultSet.getInt("total"));
                    orders.setDiscount(resultSet.getInt("discount"));
                    orders.setIsPaid(resultSet.getBoolean("is_paid"));
                    data.put(orders.toJsonObject());
                } else if (tableName.equals("reviews")) {
                    Reviews reviews = new Reviews();
                    reviews.setReviewId(resultSet.getInt("review_id"));
                    reviews.setStar(resultSet.getInt("star"));
                    reviews.setDescription(resultSet.getString("description"));
                    reviews.setOrderId(resultSet.getInt("order_id"));
                    data.put(reviews.toJsonObject());
                } else if (tableName.equals("order_details")) {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderId(resultSet.getInt("order_id"));
                    orderDetails.setProduct(resultSet.getInt("product"));
                    orderDetails.setQuantity(resultSet.getInt("quantity"));
                    orderDetails.setPrice(resultSet.getInt("price"));
                    data.put(orderDetails.toJsonObject());
                }
            }

            // Menutup koneksi ke database
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Mengatur indentasi pada JSON
        response = data.toString(2);
        return response;
    }
}
