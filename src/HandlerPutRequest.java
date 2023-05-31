import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class `HandlerPutRequest` menangani permintaan HTTP dengan metode PUT.
 */

public class HandlerPutRequest {
    private static String path;
    private static int statusCode;
    private static String id;
    private static String response;
    private static String tableName;
    private static String[] pathSegments;
    private static JSONArray data = new JSONArray();

    public static void handlePutRequest(HttpExchange exchange) throws SQLException, IOException {
        data.clear();
        OutputStream outputStream = exchange.getResponseBody();
        JSONObject jsonObject = new JSONObject();

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();

        // Memisahkan path menjadi endpoint dan id
        pathSegments = path.split("/");

        if (pathSegments.length == 3) {
            tableName = pathSegments[1];
            id = pathSegments[2];
        } else {
            jsonObject.put("status_code", 200);
            jsonObject.put("message", "Invalid path. Please specify a valid table name. " + tableName + " is unvalid.");
            data.put(jsonObject);
        }

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
                user.updateUser(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        } else if (tableName.equals("addresses")) {
            Addresses addresses = new Addresses();
            if (addresses.parseAddressesJSON(json) != 1) {
                addresses.updateAddress(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        } else if (tableName.equals("products")) {
            Products products = new Products();
            if (products.parseProductsJSON(json) != 1) {
                products.updateProduct(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        } else if (tableName.equals("orders")) {
            Orders orders = new Orders();
            if (orders.parseOrdersJSON(json) != 1) {
                orders.updateOrder(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        } else if (tableName.equals("order_details")) {
            OrderDetails orderDetails = new OrderDetails();
            if (orderDetails.parseOrderDetailsJSON(json) != 1) {
                orderDetails.updateOrderDetails(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        } else if (tableName.equals("reviews")) {
            Reviews reviews = new Reviews();
            if (reviews.parseReviewsJSON(json) != 1) {
                reviews.updateReview(id);
                jsonObject.put("status_code", 200);
                jsonObject.put("message", "Data " + tableName + " has been successfully updated.");
                data.put(jsonObject);
            } else {
                jsonObject.put("status_code", 400);
                jsonObject.put("message", "Data in " + tableName + " is not valid.");
                data.put(jsonObject);
            }
        }

        statusCode = jsonObject.getInt("status_code");
        response = data.toString(2);
        exchange.sendResponseHeaders(statusCode, response.length());
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
