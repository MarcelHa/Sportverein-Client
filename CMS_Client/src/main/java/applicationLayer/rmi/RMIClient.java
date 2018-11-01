package applicationLayer.rmi;

import applicationLayer.interfaces.MemberRemotable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {


    public void rmi() throws RemoteException, NotBoundException, MalformedURLException{

        System.setSecurityManager(new SecurityManager());
        MemberRemotable stub = (MemberRemotable) Naming.lookup("rmi://172.22.32.123:1099/Server");
        stub.test();
    }

     /*public void getInstance()throws Exception{
        if(rmiClient == null){
            rmiClient = new RMIClient();
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new SecurityManager());
            }
            //stub = (MemberRemotable) registry.lookup("Server");
            stub = (MemberRemotable) Naming.lookup("rmi://172.22.32.123:1099/Server");
        }
    }*/




}
