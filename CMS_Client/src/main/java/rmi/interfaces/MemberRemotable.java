package rmi.interfaces;

import rmi.dto.PersonDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MemberRemotable extends Remote {

    void addNewMember(PersonDTO personDTO) throws RemoteException;

    void deleteMember(int personID)throws RemoteException;

    void updateMember(PersonDTO personDTO) throws RemoteException;

    List<PersonDTO> getAllMember() throws RemoteException;

}
