import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.OutputStream;

public class HandlerPutRequest {

    private static String path;
    private static int statusCode;
    private static String id;
    private static String response;
    private static String tableName;
    private static String[] pathSegments;

    public static void handlePutRequest(HttpExchange exchange) throws SQLException,
            IOException {

        OutputStream outputStream = exchange.getResponseBody();

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();

        // Memisahkan path menjadi endpoint dan id
        pathSegments = path.split("/");

        if (pathSegments.length == 3) {
            tableName = pathSegments[1];
            id = pathSegments[2];
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
                user.updateUser(id);
                response = "Data has been successfully updated.";
                statusCode = 200;
            } else {
                response = "Data is not valid.";
                statusCode = 400;
            }
        } 

        exchange.sendResponseHeaders(statusCode, response.length());
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
// String response = "";
// Connection connection = null;
// PreparedStatement statement = null;

// try {
// connection = DatabaseConnection.getConnection();

// // Mendapatkan ID data dari path permintaan
// String id = exchange.getRequestURI().getPath().split("/")[2];

// // Membaca data dari body permintaan
// BufferedReader reader = new BufferedReader(new
// InputStreamReader(exchange.getRequestBody()));
// String requestData = reader.readLine();

// // Memperbarui data dalam database
// String query = "UPDATE mytable SET column_name = ? WHERE id = ?";
// statement = connection.prepareStatement(query);
// statement.setString(1, requestData);
// statement.setString(2, id);
// statement.executeUpdate();

// response = "Data updated successfully";
// } finally {
// closeResources(null, statement, connection);
// }

// return response;
// }
// }