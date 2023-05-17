import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // Percobaan untuk test koneksi
        // String response = "Hello, World!"; // Contoh respon API
        // exchange.sendResponseHeaders(200, response.length());
        // OutputStream outputStream = exchange.getResponseBody();
        // outputStream.write(response.getBytes());
        // outputStream.close();

        String response = "";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Membuat koneksi ke database
            connection = DatabaseConnection.getConnection();

            // Menjalankan query ke database
            String query = "SELECT * FROM mytable";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Memproses hasil query
            while (resultSet.next()) {
                // Mengambil data dari setiap baris
                String data = resultSet.getString("column_name");
                // Lakukan sesuatu dengan data
                response += data + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup sumber daya
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

        // Mengirim respon ke klien
        exchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
