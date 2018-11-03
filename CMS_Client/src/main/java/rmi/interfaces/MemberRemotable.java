package rmi.interfaces;

import rmi.dto.PersonDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MemberRemotable extends Remote {

    void addNewMember(PersonDTO personDTO) throws RemoteException;

    void deleteMember(int personID);

    void updateMember(PersonDTO personDTO);

}
