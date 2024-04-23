import java.rmi.*;

public class AddClient{
    public static void main(String[] args){
        try{
            String addServerURL = "rmi://" + args[0] + "/AddServer";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            System.out.println("The number is: " + args[1]);
            double d1 = Double.parseDouble(args[1]);

            System.out.println("The factorial of the number is: "+ addServerIntf.fct(d1));
        }
        catch (Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}