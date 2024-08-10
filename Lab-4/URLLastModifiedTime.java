import java.net.*;
import java.util.Date;

public class URLLastModifiedTime {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.acem.edu.np/");
        URLConnection con = url.openConnection();
        long lastModified = con.getLastModified();
        Date date = new Date(lastModified);
        System.out.println("Last modified time: " + date);
    }
}