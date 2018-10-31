package applicationLayer;


import applicationLayer.dto.PersonDTO;
import applicationLayer.rmi.RMIClient;


public class MemberHandler {

    public void add(PersonDTO personDTO){
        try {
            RMIClient rmiClient = new RMIClient();
            rmiClient.getInstance();
            rmiClient.getStub().addMember(personDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
