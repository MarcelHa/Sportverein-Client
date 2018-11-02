package applicationLayer;

import applicationLayer.rmi.RMIClient;


public class MemberHandler {

    public void doIt(){
        try {
            RMIClient rmiClient = new RMIClient();
            rmiClient.rmi();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
