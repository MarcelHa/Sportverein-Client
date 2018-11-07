package utilities;

import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EmptyListeners {

    public static void Person(TextField firstName, TextField lastName, DatePicker birthday, TextField ssn) {
        ArrayList<Control> checkEmptyList = new ArrayList<>();
        ValidationListener validationListener = new ValidationListener();
        checkEmptyList.add(firstName);
        checkEmptyList.add(lastName);
        checkEmptyList.add(birthday);
        checkEmptyList.add(ssn);
        for (int i = 0; i < checkEmptyList.size(); i++) {
            validationListener.addEmptyListener(checkEmptyList.get(i));
        }
    }



}
