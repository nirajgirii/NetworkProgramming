import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        // Define server port
        int serverPort = 8848;
        try {
            // Create a UDP socket
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            System.out.println("UDP is running in " + serverPort);
            while (true) {
                // Create a buffer to receive incoming packets
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);

                // Receive the packet from the client
                serverSocket.receive(receivePacket);

                // Get the client&#39;s IP address and port
                InetAddress clientAddress = receivePacket.getAddress();

                int clientPort = receivePacket.getPort();
                // Convert the received data to a string
                String clientMessage = new String(receivePacket.getData()).trim();
                System.out.println("Message received from client: " + clientMessage);

                // Process the message (e.g., perform some computation)
                String serverResponse = "Hello, client! Your message has been received.";

                // Convert the response to bytes
                byte[] sendData = serverResponse.getBytes();

                // Create a UDP packet with the server&#39;s response
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        clientAddress, clientPort);

                // Send the response to the client
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}