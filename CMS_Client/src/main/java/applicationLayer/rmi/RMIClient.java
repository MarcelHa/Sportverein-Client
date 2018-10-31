package applicationLayer.rmi;

import applicationLayer.interfaces.Remotable;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private static RMIClient rmiClient;
    private Registry registry;
    private static Remotable stub;

    private RMIClient() throws RemoteException {
        registry = LocateRegistry.getRegistry();
    }


    public static RMIClient getInstance()throws Exception{
        if(rmiClient == null){
            rmiClient = new RMIClient();
        }
        return rmiClient;
    }


}
