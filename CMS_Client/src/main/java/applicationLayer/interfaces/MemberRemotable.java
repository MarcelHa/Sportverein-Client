package applicationLayer.interfaces;

import applicationLayer.dto.PersonDTO;

import java.rmi.Remote;

public interface MemberRemotable extends Remote {

    void addMember(PersonDTO personDTO);

    //Collection<PersonDTO> displayMembers();



}
