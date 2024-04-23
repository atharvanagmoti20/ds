import java.rmi.*;

public interface AddServerIntf extends Remote{
    double ctof(double d1) throws RemoteException;
    
}
