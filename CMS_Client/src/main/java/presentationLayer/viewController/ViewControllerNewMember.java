package presentationLayer.viewController;

import applicationLayer.NewMemberHandler;
import applicationLayer.domain.Person;
import applicationLayer.interfaces.Iperson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentationLayer.SceneController;
import utilities.UtilDate;

import java.io.IOException;
import java.util.Date;

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
        Iperson person = new Person();

        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setDateOfBirth(toDate(birthday));
        person.setSocialSecurityNumber(ssn.getText());

        NewMemberHandler newMemberHandler = new NewMemberHandler();
        newMemberHandler.addNewMeber(person);
    }

    //Date Converter
    private Date toDate(DatePicker datePicker){
        UtilDate utilDate = new UtilDate();
        return  utilDate.convertToDate(datePicker.getValue());
    }







}
