import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * `MyHandler` adalah implementasi dari interface HttpHandler yang digunakan
 * untuk menangani permintaan HTTP.
 * Kelas ini menyediakan logika untuk memproses permintaan HTTP yang masuk dan
 * menghasilkan respons yang sesuai.
 */
public class MyHandler implements HttpHandler {
    private static String method;
    private static String response = "";
    private static int statusCode = 200;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            // Mendapatkan method dari permintaan
            method = exchange.getRequestMethod();

            // Melakukan pengecekan kondisi berdasarkan method request
            if (method.equalsIgnoreCase("GET")) {
                response = HandlerGetRequest.handleGetRequest(exchange);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(statusCode, response.getBytes().length);
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            } else if (method.equalsIgnoreCase("POST")) {
                HandlerPostRequest.handlePostRequest(exchange);
            } else if (method.equalsIgnoreCase("PUT")) {
                HandlerPutRequest.handlePutRequest(exchange);
            } else if (method.equalsIgnoreCase("DELETE")) {
                HandlerDeleteRequest.handleDeleteRequest(exchange);
            } else {
                statusCode = 405;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            statusCode = 500;
        }
    }
}
