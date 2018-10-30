package rmi;

import java.rmi.Remote;

public interface RMIRemotable extends Remote {

    void doIt() throws Exception;
}
