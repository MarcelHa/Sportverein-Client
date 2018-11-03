package applicationLayer;

import rmi.RMIClient;
/*
Is used by the presentation layer for the View Controller New Member
 */

public class MemberHandler {

    public void addNewMember(){
        try {
            RMIClient.getInstance().setMemberRemotable().addNewMember();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
