//WAP to find the host name of the given IP address.


import java.net.InetAddress;

public class FindHostName {
    public static void main(String args[]){
        String ipAddress = "31.13.71.36";

        try {
            InetAddress internetAddress = InetAddress.getByName(ipAddress);
            System.out.println("Canonical Host Name: " + internetAddress.getCanonicalHostName());
        }catch(Exception e){
            System.err.println("Host not found of Ip address: " + ipAddress  + e.getMessage());
            e.printStackTrace();
        }
    }
}