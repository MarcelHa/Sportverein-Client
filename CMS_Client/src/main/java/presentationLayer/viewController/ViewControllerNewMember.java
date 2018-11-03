package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import applicationLayer.dto.PersonDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentationLayer.SceneController;
import utilities.UtilDate;
import java.io.IOException;
import java.sql.Date;


public class ViewControllerNewMember extends SceneController {

    @FXML
    Button addMember;
    @FXML
    TextField firstName, lastName, ssn;
    @FXML
    DatePicker birthday;
    @FXML
    ChoiceBox team;


    /*
    Simple Dashboard Navigation
     */
    @FXML
    public void switchToMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "member.fxml");
    }
    @FXML
    public void switchToClub(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "club.fxml");
    }
    @FXML
    public void switchToEvent(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "event.fxml");
    }
    @FXML
    public void switchToHome(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "home.fxml");
    }
    @FXML
    public void switchToResult(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "result.fxml");
    }
    @FXML
    public void switchToEditMember(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "editMember.fxml");
    }


    /*
    Presentation Layer Logic
     */
    @FXML
    public void addNewMember(){

        PersonDTO person = new PersonDTO();
        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setDateOfBirth(toDate(birthday));
        person.setSocialSecurityNumber(ssn.getText());

        MemberHandler memberHandler = new MemberHandler();
        memberHandler.addNewMember();
    }

    //Date Converter
    private Date toDate(DatePicker datePicker){
        return UtilDate.convertToSQLDate(datePicker.getValue());
    }







}
