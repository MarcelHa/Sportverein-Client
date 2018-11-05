package presentationLayer;

import rmi.dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private static List<PersonDTO> mementoList = new ArrayList<PersonDTO>();

    public static void add(PersonDTO personData){
        mementoList.add(personData);
    }

    public static PersonDTO get(){
        return mementoList.get(0);
    }
}
