import java.net.*;

public class PrintURLConnectionURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            System.out.println("URL of connection: " + connection.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}