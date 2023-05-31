import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class `HandlerPostRequest` menangani permintaan HTTP dengan metode POST.
 */

public class HandlerPostRequest {
    private static String path;
    private static String tableName;
    private static String response;
    private static String[] pathSegments;
    private static int statusCode;
    private static JSONArray data = new JSONArray();

    public static void handlePostRequest(HttpExchange exchange) throws SQLException, IOException {
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

            if (pathSegments.length == 2) {
                tableName = pathSegments[1];

                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                int i;
                StringBuilder buf = new StringBuilder();

                while ((i = br.read()) != -1) {
                    buf.append((char) i);
                }

                br.close();
                isr.close();
                String json = buf.toString();

                if (tableName.equals("users")) {
                    Users user = new Users();
                    if (user.parseUserJSON(json) != 1) {
                        user.insertUser();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
                } else if (tableName.equals("addresses")) {
                    Addresses addresses = new Addresses();
                    if (addresses.parseAddressesJSON(json) != 1) {
                        addresses.insertAddress();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
                } else if (tableName.equals("products")) {
                    Products products = new Products();
                    if (products.parseProductsJSON(json) != 1) {
                        products.insertProduct();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
                } else if (tableName.equals("orders")) {
                    Orders orders = new Orders();
                    if (orders.parseOrdersJSON(json) != 1) {
                        orders.insertOrder();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
                } else if (tableName.equals("order_details")) {
                    OrderDetails orderDetails = new OrderDetails();
                    if (orderDetails.parseOrderDetailsJSON(json) != 1) {
                        orderDetails.insertOrderDetails();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
                } else if (tableName.equals("reviews")) {
                    Reviews reviews = new Reviews();
                    if (reviews.parseReviewsJSON(json) != 1) {
                        reviews.insertReview();
                        jsonObject = Fitur.insertDataSuccess(tableName);
                    } else {
                        jsonObject = Fitur.insertDataError(tableName);
                    }
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
}
