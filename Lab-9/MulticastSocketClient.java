import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketClient {
    public static void main(String[] args) {
        try {
            // Multicast group and port
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 8888;

            // Create a multicast socket and join the group
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            // Buffer for received data
            byte[] buf = new byte[1024];

            // Datagram packet for receiving data
            DatagramPacket pkt = new DatagramPacket(buf, buf.length);

            while (true) {
                // Receive a packet
                socket.receive(pkt);

                // Extract the received data
                String data = new String(pkt.getData(), 0, pkt.getLength());

                // Check if the packet is from the desired host
                if (pkt.getAddress().getHostAddress().equals("192.168.0.100")) {
                    System.out.println("Received data from host: " + data);
                } else {
                    System.out.println("Received data from different host: " + data);
                }

                // Clear the buffer for the next packet
                pkt.setLength(buf.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
