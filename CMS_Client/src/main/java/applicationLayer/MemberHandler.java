package applicationLayer;

import rmi.dto.PersonDTO;
import rmi.RMIClient;
import rmi.dto.RoleDTO;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
/*
Is used by the presentation layer for the View Controller New Member
 */

public class MemberHandler {

    public void addNewMember(PersonDTO personDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setMemberRemotable().addNewMember(personDTO);
    }

    public List<PersonDTO> getAllMember() throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setMemberRemotable().getAllMember();
    }


    public void deleteMember(PersonDTO personDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setMemberRemotable().deleteMember(personDTO);
    }

    public void updateMember(PersonDTO personDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setMemberRemotable().updateMember(personDTO);
    }


    public PersonDTO addRolesToPersonDTO(PersonDTO person) throws RemoteException,  NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setMemberRemotable().addRolesToPersonDTO(person);
    }

    public List<RoleDTO> getRolesFromPersonDto(PersonDTO person) throws RemoteException,  NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setMemberRemotable().getRolesFromPersonDto(person);
    }

    public List<RoleDTO> getAllRoles() throws RemoteException,  NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setMemberRemotable().getAllRoles();
    }




}
