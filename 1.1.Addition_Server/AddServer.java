import java.rmi.*;

public class AddServer {
    public static void main (String args[]){
        try {
            AddServerImpl addServerImpl = new AddServerImpl();

            Naming.rebind("AddServer", addServerImpl);
        }
        catch (exception e) {System.out.println("Exception: " + e);}
        
    }
}