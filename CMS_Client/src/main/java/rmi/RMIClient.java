package rmi;


import rmi.interfaces.MemberRemotable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

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
        MemberRemotable stub = (MemberRemotable) Naming.lookup("rmi://localhost/Server");
        return stub;
    }

}
