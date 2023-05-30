import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.OutputStream;

public class HandlerPostRequest {

    private static Connection conn;
    private static String path;
    private static String response;
    private static String tableName;
    private static String[] pathSegments;
    private static String query;

    public static void handlePostRequest(HttpExchange exchange) throws SQLException,
            IOException {
        OutputStream outputStream = exchange.getResponseBody();

        // Mendapatkan path dari permintaan
        path = exchange.getRequestURI().getPath();

        // Memisahkan path menjadi endpoint dan id
        pathSegments = path.split("/");

        if (pathSegments.length == 2) {
            tableName = pathSegments[1];
        } else {
            response = "Invalid path. Please specify a valid table name.";
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
                response = "Data berhasil dimasukkan";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            } else {
                response = "Data tidak sesuai";
                exchange.sendResponseHeaders(400, response.getBytes().length);
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
    }
}
