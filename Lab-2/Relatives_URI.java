import java.net.URI;
import java.net.URL;

public class Relatives_URI {
    public static void main(String[] args) throws Exception {
        String baseUrlString = "https://example.com";
        String relativeUriString = "/page.html";

        URL baseUrl = new URL(baseUrlString);
        URI relativeUri = new URI(relativeUriString);

        URI resolvedUri = baseUrl.toURI().resolve(relativeUri);
        String resolvedUriString = resolvedUri.toString();

        System.out.println("Resolved URI: " + resolvedUriString);
    }
}