import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{}
}

public double fct(double d1) throws RemoteException{
    double fact = 1;
    for (double i=1; i <= d1; i++){
        fact *= i;
    }
    return fact;
}