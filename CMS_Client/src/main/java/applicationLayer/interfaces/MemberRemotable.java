package applicationLayer.interfaces;

import applicationLayer.dto.PersonDTO;

import java.rmi.Remote;

public interface MemberRemotable extends Remote {

    /*
    Methods for DTO's
     */
    void addMember(PersonDTO personDTO);

    //Collection<PersonDTO> displayMembers();



}
