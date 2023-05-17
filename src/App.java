import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(1087), 0);
        server.createContext("/api", new MyHandler()); // Menetapkan handler ke path tertentu
        server.setExecutor(null); // Menggunakan executor default
        server.start(); // Memulai server
    }
}
