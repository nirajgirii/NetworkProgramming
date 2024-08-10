import java.net.InetAddress;

public class DomainNameVerify {
    public static void main(String args[]){
        String domainOne = "www.google.com";
        String domainTwo = "www.facebook.com";

        try{

            InetAddress inetAddressOne = InetAddress.getByName(domainOne);
            InetAddress inetAddressTwo = InetAddress.getByName(domainTwo);

            System.out.println("The Ipaddress of " + domainOne + " is: " + inetAddressOne.getHostAddress());
            System.out.println("The Ipaddress of " + domainTwo + " is: " + inetAddressTwo.getHostAddress());

            if(inetAddressOne.equals(inetAddressTwo))
                System.out.println("Both the domains are hosted on the same server.");
            else
                System.out.println("Both the domains are hosted on different servers.");

        }catch(Exception e){
            System.out.println("Exception caught = " + e.getMessage());
        }
    }
}
