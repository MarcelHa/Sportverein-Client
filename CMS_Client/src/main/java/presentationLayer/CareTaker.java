package presentationLayer;

import rmi.dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private static List<PersonDTO> mementoList = new ArrayList<>();
    private static final int NUMB = 1;

    public static void add(PersonDTO personData){
        mementoList.add(personData);
    }

    public static PersonDTO getMemento(){
        try {
            return mementoList.get(mementoList.size()-NUMB);
        }catch (NullPointerException ex){
            ex.printStackTrace();
            return new PersonDTO();
        }finally {
            mementoList.clear();
        }
    }
}
