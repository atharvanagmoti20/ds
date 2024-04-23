import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import org.orb.*;
import ReverseModule.*;

public class ReverseClient {
    public static void main(String[] args) {
        try {
            
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object obj_ref = orb.resolve_initial_references("NamingServices");
            NamingContextExt ncRef = NamingContextExtHelper.narrow("obj_ref");

            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(name);

            System.out.println("Enter String");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            String temp = ReverseImpl.reverse_String(str);
            System.out.println(temp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
