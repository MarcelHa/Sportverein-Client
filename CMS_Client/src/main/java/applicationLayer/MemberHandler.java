package applicationLayer;

import rmi.dto.PersonDTO;
import rmi.RMIClient;
/*
Is used by the presentation layer for the View Controller New Member
 */

public class MemberHandler {

    public void addNewMember(PersonDTO personDTO){
        try {
            RMIClient.getInstance().setMemberRemotable().addNewMember(personDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
