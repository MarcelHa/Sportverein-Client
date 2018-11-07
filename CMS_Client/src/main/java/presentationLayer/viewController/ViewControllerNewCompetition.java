package presentationLayer.viewController;

import applicationLayer.CompetitionHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentationLayer.SceneController;
import rmi.dto.CompetitionDTO;

import rmi.dto.TeamDTO;
import utilities.UtilDate;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewControllerNewCompetition extends SceneController implements Initializable {

    @FXML
    private TextField compName, location;
    @FXML
    private DatePicker date;
    @FXML
    private ChoiceBox sport, league;

    private List<TeamDTO> _availableTeamList;
    private ObservableList<TeamDTO> _availableTeamsObservableList;
    private ObservableList<TeamDTO> _attachedTeamsObservableList;
    private CompetitionHandler _competitionHandler = new CompetitionHandler();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    /*
    Simple Dashboard Navigation
     */
    @FXML
    public void switchToMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "member.fxml");
    }
    @FXML
    public void switchToClub(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "club.fxml");
    }
    @FXML
    public void switchToEvent(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "event.fxml");
    }
    @FXML
    public void switchToNewEvent(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "newEvent.fxml");
    }
    @FXML
    public void switchToEditEvent(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "editEvent.fxml");
    }
    @FXML
    public void switchToHome(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "home.fxml");
    }
    @FXML
    public void switchToResult(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "result.fxml");
    }

    /*
    Presentation Layer Logic
     */
    @FXML
    public void addNewCompetition(ActionEvent actionEvent) throws IOException{
        CompetitionDTO competitionDTO = new CompetitionDTO();

        competitionDTO.setCompName(compName.getText());
        competitionDTO.setLocation(location.getText());
        competitionDTO.setTeamList(_attachedTeamsObservableList);
        competitionDTO.setStartDate(UtilDate.convertToSQLDate(date.getValue()));
    }

}
