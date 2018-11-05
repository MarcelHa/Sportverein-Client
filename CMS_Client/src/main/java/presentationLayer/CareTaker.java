package presentationLayer;

import rmi.dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private static List<PersonDTO> mementoList = new ArrayList<>();
    public static final int INDEX = 0;


    public static void add(PersonDTO personData){
        mementoList.add(personData);
    }

    public static PersonDTO getFirst(){
        return mementoList.get(INDEX);
    }

    public static void clear(){
        mementoList.clear();
    }
}
