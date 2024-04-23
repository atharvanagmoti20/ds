import java.rmi.*;

public interface AddServerIntf extends Remote {
    double fct(double d1) throws RemoteException;
}