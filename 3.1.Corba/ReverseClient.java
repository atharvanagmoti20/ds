import ReverseModule.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class ReverseClient {
    
    public static void main(String[] args) {
        try {
            
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameServices");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter String");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            String tempString = ReverseImpl.reverse_String(str);

            System.out.println(tempString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
