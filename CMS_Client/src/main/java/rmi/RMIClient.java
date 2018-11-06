package rmi;


import rmi.interfaces.FactoryRemotable;
import rmi.interfaces.MemberRemotable;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    private static String serverIP = "localhost";

    private static RMIClient rmiClient;

    private RMIClient(){}


    public static RMIClient getInstance(){
        if(rmiClient == null){
            rmiClient = new RMIClient();
            return new RMIClient();
        }
        return rmiClient;
    }

    public MemberRemotable setMemberRemotable () throws RemoteException, NotBoundException, MalformedURLException {
        System.setSecurityManager(new SecurityManager());
        FactoryRemotable factoryStub = (FactoryRemotable) Naming.lookup("rmi://" + serverIP + "/Factory");
        return factoryStub.factoryMember();
    }

//    public RoleRemotable setRoleRemotable () throws RemoteException, NotBoundException, MalformedURLException {
//        System.setSecurityManager(new SecurityManager());
//        RoleRemotable stub = (RoleRemotable) Naming.lookup("rmi://" + serverIP + "/Roles");
//        return stub;
//    }
}
