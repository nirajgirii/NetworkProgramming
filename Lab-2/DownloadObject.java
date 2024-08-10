import java.io.*;
import java.net.*;

public class DownloadObject {
    public static void main(String[] args) {

        try {
            URL u = new URL(("http://www.google.com"));
            Object o = u.getContent();
            System.out.println("I got a" + o.getClass().getName());
        }

        catch (MalformedURLException ex) {
            System.err.println("is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}