import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int serverPort = 1345;

        try {
            Socket clientSocket = new Socket(serverHostname, serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // Send a message to the server
            String message = "Hello, server!";
            out.println(message);
            out.flush();
            System.out.println("Sent message to server: " + message);

            // Read the server&#39;s response
            String response = in.readLine();
            System.out.println("Received response from server: " + response);

            // Close the connection
            clientSocket.close();
            System.out.println("Connection closed");

        } catch (IOException e) {
            System.err.println("Exception caught: " + e);
        }
    }
}