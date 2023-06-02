import java.io.FileNotFoundException;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import java.io.File;
import java.util.*;

public class APIKeyProvider {
    public static Boolean apiAuthorization(HttpExchange exchange) throws FileNotFoundException {
        Headers requestHeaders = exchange.getRequestHeaders();
        String headersKey = "API-KEY:" + requestHeaders.getFirst("API-KEY");    
        ArrayList <String> keyArrayList= new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : requestHeaders.entrySet()) {
            String key = entry.getKey();  // Mendapatkan key
            keyArrayList.add(key);
        }
        
        File file = new File(".env");
        String apiKey = null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("API-KEY")) {
                apiKey = line;
            } 
        }
        scanner.close();

        if (keyArrayList.contains("Api-key")) {
            if (headersKey.equalsIgnoreCase(apiKey)) {
                return true;
            } 
        }
        
        return false;
    }
}
