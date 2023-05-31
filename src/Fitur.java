import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.SQLException;
import java.io.OutputStream;
import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

public class Fitur {
    public static boolean isValidTable(String tableName) {
        // Daftar tabel yang valid
        String[] validTables = { "users", "products", "orders", "addresses", "order_details", "reviews" };

        // Memeriksa apakah tabel ada dalam daftar tabel yang valid
        for (String validTable : validTables) {
            if (validTable.equalsIgnoreCase(tableName)) {
                return true;
            }
        }

        return false;
    }

    public static void invalidMethod(HttpExchange exchange) throws SQLException, IOException {
        OutputStream outputStream = exchange.getResponseBody();
        String method = exchange.getRequestMethod();
        JSONObject jsonObject = new JSONObject();
        JSONArray data = new JSONArray();
        jsonObject.put("status_code", 400);
        jsonObject.put("message",
                "Invalid request method. The API only handles GET, POST, PUT, and DELETE methods. Method " + method
                        + " is not allowed. ");
        data.put(jsonObject);
        int statusCode = jsonObject.getInt("status_code");
        String response = data.toString(2);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static JSONObject invalidPath(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 400);
        jsonObject.put("message", "Invalid path. Please specify a valid path. Path " + path + " is unavailable for "
                + method + " method.");
        return jsonObject;
    }

    public static JSONObject unvaliableTable(String tableName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 400);
        jsonObject.put("message",
                "Invalid table. Please specify a valid table name. Table " + tableName + " is unavailable");
        return jsonObject;
    }

    public static JSONObject insertDataSuccess(String tableName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 200);
        jsonObject.put("message", "Data " + tableName + " has been successfully inserted.");
        return jsonObject;
    }

    public static JSONObject insertDataError(String tableName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 400);
        jsonObject.put("message", "Invalid data. Please insert a " + tableName + " valid data.");
        return jsonObject;
    }

    public static JSONObject updateDataSuccess(String tableName, String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 200);
        jsonObject.put("message", "Data in " + tableName + " with id = " + id + " has been successfully updated.");
        return jsonObject;
    }

    public static JSONObject updateDataError(String tableName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 400);
        jsonObject.put("message", "Data in " + tableName + " is not valid.");
        return jsonObject;
    }

    public static JSONObject deleteDataSuccess(String tableName, String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", 200);
        jsonObject.put("message", "Data in " + tableName + " with id " + id + " has been successfully deleted.");
        return jsonObject;
    }
}
