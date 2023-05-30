import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class App {

    private static int port = 8087;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler()); // Menetapkan handler ke path tertentu
        server.setExecutor(null); // Menggunakan executor default
        server.start(); // Memulai server
        System.out.println("Server started on port " + port);
    }
}
