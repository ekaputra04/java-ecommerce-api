import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class HandlerPostRequest {
    public static String handlePostRequest(HttpExchange exchange) throws SQLException,
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

    private static void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection) {
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
