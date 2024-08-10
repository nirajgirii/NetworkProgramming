import java.net.*;
import java.io.*;

public class HTTPClient {
    public static void main(String[] args) {
        try {
            // Create a URL object for the desired page
            URL url = new URL("http://127.0.0.1:8000");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Send the request and receive the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}