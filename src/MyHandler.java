import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
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

            // Validasi API Key
            if (!APIKeyProvider.apiAuthorization(exchange)) {
                Fitur.invalidAPIKey(exchange);
                System.out.println("API KEY is unvaliable");
            } else if (APIKeyProvider.apiAuthorization(exchange)) {
                // Melakukan pengecekan kondisi berdasarkan method request
                if (method.equalsIgnoreCase("GET")) {
                    response = HandlerGetRequest.handleGetRequest(exchange);
                    Fitur.response(exchange, statusCode, response);
                } else if (method.equalsIgnoreCase("POST")) {
                    HandlerPostRequest.handlePostRequest(exchange);
                } else if (method.equalsIgnoreCase("PUT")) {
                    HandlerPutRequest.handlePutRequest(exchange);
                } else if (method.equalsIgnoreCase("DELETE")) {
                    HandlerDeleteRequest.handleDeleteRequest(exchange);
                } else {
                    Fitur.invalidMethod(exchange);
                }
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
            statusCode = 500;
        }
    }
}
