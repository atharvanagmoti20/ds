import ReverseModule.*;
import org.omg.*;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

class ReverseServer {
    public static void main(String[] args) {
        try{
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,  null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            ReverseImpl rvr = new  ReverseImpl();

            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);

            org.omg.CORBA.Object obj_ref = orb.resolve_initial_references("NamingService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj_ref);

            NameComponent path[] = ncRef.to_name("Reverse");
            ncRef.rebind(path, h_ref);

            System.out.println("Reverse Server reading and waiting....");
            orb.run();

    }
    catch (Exception e){
        e.printStackTrace();
    }
    
}

}
