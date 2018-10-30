package rmi;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private static RMIClient rmiClient;
    private Registry registry;
    private RMIRemotable stub;

    private RMIClient() throws RemoteException, NotBoundException{
        registry = LocateRegistry.getRegistry();
        stub = (RMIRemotable)registry.lookup("String");
    }


    public static RMIClient getInstance()throws Exception{
        if(rmiClient == null){
            rmiClient = new RMIClient();
        }
        return rmiClient;
    }

    public RMIRemotable getStub() {
        return stub;
    }


}
