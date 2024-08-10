import java.net.InetAddress;

public class CheckIPv4OrIPv6 {
    public static void main(String args[]){
        String ipAddress = "192.168.1.1";

        try{
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            if(inetAddress instanceof java.net.Inet4Address){
                System.out.println(ipAddress + " is an IPv4 address.");
            }

            else if(inetAddress instanceof java.net.Inet6Address){
                System.out.println(ipAddress + " is an IPv6 address.");
            }

            else
                System.out.println(inetAddress + " is not an IP address.");

        }catch(Exception e){
            System.out.println("Exception caught = " + e.getMessage());
        }
    }  
}
