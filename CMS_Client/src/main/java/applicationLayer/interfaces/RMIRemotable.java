package applicationLayer.interfaces;

import java.rmi.Remote;

public interface RMIRemotable extends Remote {

    public void addMember(Iperson person);

    public Iperson editMember();
}
