
import java.net.InetAddress;

public class CheckReachability {
    public static void main(String args[]){
        String remoteIpAddress = "8.8.8.8";
        int timeout = 5000;

        try {
            InetAddress remoteAddress = InetAddress.getByName(remoteIpAddress);

            if(remoteAddress.isReachable(timeout)){
                System.out.println("Host is reachable.");
            }
            else {
                System.out.println("Host is unreachable");
            }

        }catch(Exception e){
            System.out.println("Exception caught = " + e.getMessage());
        }

    }    
}
