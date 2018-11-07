package utilities;

import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Validation {

    public static boolean person(TextField firstName, TextField lastName, DatePicker birthday, TextField ssn) {
        boolean isAllReqFields = true;
        ArrayList<Control> checkEmptyList = new ArrayList<>();
        StyleValidation styleValidation = new StyleValidation();
        checkEmptyList.add(firstName);
        checkEmptyList.add(lastName);
        checkEmptyList.add(birthday);
        checkEmptyList.add(ssn);
        for (int i = 0; i < checkEmptyList.size(); i++) {
            if (styleValidation.markedListEntry(checkEmptyList.get(i))) {
                isAllReqFields = false;
            }
        }
        return isAllReqFields;
    }
}
