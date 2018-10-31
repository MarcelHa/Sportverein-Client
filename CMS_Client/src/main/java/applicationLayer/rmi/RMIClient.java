package applicationLayer.rmi;

import applicationLayer.interfaces.EventRemotable;
import applicationLayer.interfaces.MemberRemotable;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private static RMIClient rmiClient;
    private static Registry registry;
    private MemberRemotable stub;


    public RMIClient() throws RemoteException {
        registry = LocateRegistry.getRegistry("172.22.32.123");
    }


    public void getInstance()throws Exception{
        if(rmiClient == null){
            rmiClient = new RMIClient();
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new SecurityManager());
            }
            stub = (MemberRemotable) registry.lookup("Server");
        }
    }

    public MemberRemotable getStub(){
        return stub;
    }



}
