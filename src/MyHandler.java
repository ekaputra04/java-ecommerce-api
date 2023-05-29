import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
// import com.sun.net.httpserver.HttpServer;
// import java.net.InetSocketAddress;
// import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
// import org.json.JSONArray;
// import org.json.JSONObject;

public class MyHandler implements HttpHandler {

    public static String method;
    public static String path;
    public static String query;
    public static String response;
    public static int statusCode = 200;

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            // Mendapatkan method dari permintaan
            method = exchange.getRequestMethod();
            // Mendapatkan query dari request
            query = exchange.getRequestURI().getQuery();

            if (method.equalsIgnoreCase("GET")) {
                response = HandlerGetRequest.handleGetRequest(exchange);
            } else if (method.equalsIgnoreCase("POST")) {
                response = handlePostRequest(exchange);
            } else if (method.equalsIgnoreCase("PUT")) {
                response = handlePutRequest(exchange);
            } else if (method.equalsIgnoreCase("DELETE")) {
                response = handleDeleteRequest(exchange);
            } else {
                statusCode = 405; // Method Not Allowed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            statusCode = 500; // Internal Server Error
        }

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String handlePostRequest(HttpExchange exchange) throws SQLException,
            IOException {
        String response = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Membaca data dari body permintaan
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String requestData = reader.readLine();

            // Memasukkan data ke dalam database
            String query = "INSERT INTO mytable (column_name) VALUES (?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, requestData);
            statement.executeUpdate();

            response = "Data inserted successfully";
        } finally {
            closeResources(null, statement, connection);
        }

        return response;
    }

    private String handlePutRequest(HttpExchange exchange) throws SQLException,
            IOException {
        String response = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Mendapatkan ID data dari path permintaan
            String id = exchange.getRequestURI().getPath().split("/")[2];

            // Membaca data dari body permintaan
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String requestData = reader.readLine();

            // Memperbarui data dalam database
            String query = "UPDATE mytable SET column_name = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, requestData);
            statement.setString(2, id);
            statement.executeUpdate();

            response = "Data updated successfully";
        } finally {
            closeResources(null, statement, connection);
        }

        return response;
    }

    private String handleDeleteRequest(HttpExchange exchange) throws SQLException {
        String response = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Mendapatkan ID data dari path permintaan
            String id = exchange.getRequestURI().getPath().split("/")[2];

            // Menghapus data dari database
            String query = "DELETE FROM mytable WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();

            response = "Data deleted successfully";
        } finally {
            closeResources(null, statement, connection);
        }

        return response;
    }

    private void closeResources(ResultSet resultSet, PreparedStatement statement,
            Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
