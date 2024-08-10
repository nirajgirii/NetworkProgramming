import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class DownloadWeb {

    public static void main(String[] args) {
        // Specify the URL of the web page to be downloaded
        String webAddress = "https://www.example.com";

        // Specify the output file name
        String outputFileName = "home.html";

        // Download the web page
        downloadWebPage(webAddress, outputFileName);
    }

    public static OutputStream outputStream = null;

    static void downloadWebPage(String webAddress, String outputFileName) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Create a URL object
            URL url = new URL(webAddress);

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Check for a successful response code (HTTP 200)
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.err.println("Error: Unable to connect to the URL. Response code: " +
                        connection.getResponseCode());
                return;
            }

            // Get an input stream from the connection
            InputStream inputStream = connection.getInputStream();

            // Create a buffered reader to read the input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));

            // Create an output stream to write the content to a file
            outputStream = new FileOutputStream(outputFileName);

            // Read the web page content and write it to the file
            String line;
            while ((line = reader.readLine()) != null) {
                outputStream.write(line.getBytes());
                outputStream.write(System.lineSeparator().getBytes());

            }

            System.out.println("Web page downloaded successfully to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close all resources
            try {
                if (reader != null)
                    reader.close();
                if (outputStream != null)
                    outputStream.close();
                if (connection != null)
                    connection.disconnect();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}