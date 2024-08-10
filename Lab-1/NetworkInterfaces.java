
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfaces {
    public static void main(String args[]){

        try{
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while(interfaces.hasMoreElements()){
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println("Hardware address: " + networkInterface.getHardwareAddress());
            }
        }catch(Exception e){
            System.out.println("Exception caught = " + e.getMessage());
        }

    }    
}
