package applicationLayer;


import applicationLayer.interfaces.Iperson;

public class NewMemberHandler {


    public void addNewMeber(Iperson person){
        try {
            RMIClient.getInstance().getStub().addMember(person);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Iperson editMember(){
        try {
            return RMIClient.getInstance().getStub().editMember();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }



}
