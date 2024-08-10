
//WAP to find the IP address of the local host.

import java.net.InetAddress;

public class FindLocalIpAddress {
    public static void main(String args[]){
        try {
            InetAddress Localhost = InetAddress.getLocalHost();

            System.out.println("Local Host Name: " + Localhost.getHostName());
            System.out.println("Local Host Address: " + Localhost.getHostAddress());
        }catch(Exception e) {
        System.out.println("Exception caught = " + e.getMessage());
        }
    }
}
