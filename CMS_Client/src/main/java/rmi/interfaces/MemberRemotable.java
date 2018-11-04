package rmi.interfaces;

import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MemberRemotable extends Remote {

    void addNewMember(PersonDTO personDTO) throws RemoteException;

    void deleteMember(PersonDTO personDTO)throws RemoteException;

    void updateMember(PersonDTO personDTO) throws RemoteException;

    List<PersonDTO> getAllMember() throws RemoteException;

    PersonDTO addRolesToPersonDTO(PersonDTO person) throws RemoteException;

    List<RoleDTO> getRolesFromPersonDto(PersonDTO person) throws RemoteException;

}
