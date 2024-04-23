import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{

    }

    public double ctof(double d1) throws RemoteException{
        double farehnite = d1*(1.8)+32;
        return farehnite;
    }   
}
