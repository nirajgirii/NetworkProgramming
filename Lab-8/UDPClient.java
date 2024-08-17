import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        // Server IP and port
        String ip = "127.0.0.1";
        int port = 8848;
        try {
            // Create a UDP socket
            DatagramSocket socket = new DatagramSocket();

            // User input
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a message: ");
            String msg = input.readLine();

            // Convert message to bytes
            byte[] data = msg.getBytes();

            // Create and send packet
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(ip), port);
            socket.send(packet);

            // Receive server response
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            // Display server response
            String response = new String(responsePacket.getData());
            System.out.println("Server response: " + response.trim());

            // Close socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
