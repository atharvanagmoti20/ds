import java.rmi.*;

public class AddClient {
    public static void main(String[] args) {
        try{
            String addServerURL = "rmi://" + args[0] + "/AddServer";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);

            System.out.println("Enter the temperature in celcius"+ args[1]);
            double d1 = Double.parseDouble(args[1]);

            System.out.println("The temperature in farehnite is: "+ addServerIntf.ctof(d1));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
