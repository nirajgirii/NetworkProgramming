import java.net.*;
import java.util.*;

public class CookieHandlerExample {
    public static void main(String[] args) {
        try {
            // Set the default cookie manager
            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);

            // Create a URL object for the desired page
            URL url = new URL("http://google.com");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Send a request to the server
            connection.setRequestMethod("GET");
            connection.connect();

            // Print the cookies received from the server
            Map<String, List<String>> headerFields = connection.getHeaderFields();

            List<String> cookiesHeader = headerFields.get("Set-Cookie");
            if (cookiesHeader != null) {
                for (String cookie : cookiesHeader) {
                    cookieManager.getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
                }
            }
            System.out.println("Cookies: " + cookieManager.getCookieStore().getCookies());

            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}