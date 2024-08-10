import java.net.*;
import java.util.*;

public class PrintHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            // Get the header fields
            Map<String, List<String>> headers = connection.getHeaderFields();
            // Print the header fields
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                for (String value : values) {
                    System.out.println(key + ": " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}