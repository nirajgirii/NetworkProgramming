import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main(String[] args) {
        int serverPort = 1345;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is runnning " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted client " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Read the client&#39;s message
                String message = in.readLine();
                System.out.println("Received message from client: " + message);

                // Send a response to the client
                String response = "Hello, client!";
                out.println(response);
                out.flush();
                System.out.println("Sent response to client: " + response);

                // Close the connection
                clientSocket.close();
                System.out.println("Connection closed");
            }
        } catch (IOException e) {
            System.err.println("Exception caught: " + e);
        }
    }
}