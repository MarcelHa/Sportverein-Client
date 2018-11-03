package rmi.interfaces;

import rmi.dto.RoleDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RoleRemotable extends Remote {

    List<RoleDTO> getAllRoles() throws RemoteException;
}
