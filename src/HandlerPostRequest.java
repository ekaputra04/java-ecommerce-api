import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.OutputStream;

/**
 * Class `HandlerPostRequest` menangani permintaan HTTP dengan metode POST.
 */

public class HandlerPostRequest {
    private static String path;
    private static String tableName;
    private static String[] pathSegments;
    private static int statusCode;
    private static String response;

    public static void handlePostRequest(HttpExchange exchange) throws SQLException, IOException {

        OutputStream outputStream = exchange.getResponseBody();

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();

        // Memisahkan path menjadi endpoint dan id
        pathSegments = path.split("/");

        if (pathSegments.length == 2) {
            tableName = pathSegments[1];
        } else {
            response = "Invalid path. Please specify a valid table name.";
            statusCode = 200;
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
                user.insertUser();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        } else if (tableName.equals("addresses")) {
            Addresses addresses = new Addresses();
            if (addresses.parseAddressesJSON(json) != 1) {
                addresses.insertAddress();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        } else if (tableName.equals("products")) {
            Products products = new Products();
            if (products.parseProductsJSON(json) != 1) {
                products.insertProduct();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        } else if (tableName.equals("orders")) {
            Orders orders = new Orders();
            if (orders.parseOrdersJSON(json) != 1) {
                orders.insertOrder();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        } else if (tableName.equals("order_details")) {
            OrderDetails orderDetails = new OrderDetails();
            if (orderDetails.parseOrderDetailsJSON(json) != 1) {
                orderDetails.insertOrderDetails();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        } else if (tableName.equals("reviews")) {
            Reviews reviews = new Reviews();
            if (reviews.parseReviewsJSON(json) != 1) {
                reviews.insertReview();
                response = "Data has been successfully inserted.";
                statusCode = 200;
            } else {
                response = "Invalid data.";
                statusCode = 400;
            }
        }

        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
