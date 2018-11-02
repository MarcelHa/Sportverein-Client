package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MemberRemotable extends Remote {

    void doIt() throws RemoteException;
}
