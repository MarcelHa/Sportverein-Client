package applicationLayer.interfaces;

import applicationLayer.domain.PersonDTO;

public interface IMember {

     void addNewMember(PersonDTO personDTO);

     void editMember(PersonDTO personDTO);
}
