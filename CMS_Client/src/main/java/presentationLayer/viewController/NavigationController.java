package presentationLayer.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentationLayer.SceneController;

import java.io.IOException;

public class NavigationController extends SceneController {


    @FXML
    public void switchToMember(ActionEvent actionEvent) throws IOException{
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
    public void switchToNewMember(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "newMember.fxml");
    }
    @FXML
    public void switchToEditMember(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "editMember.fxml");
    }

    @FXML
    public void switchToNewEvent(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "newEvent.fxml");
    }
    @FXML
    public void switchToEditEvent(ActionEvent actionEvent) throws IOException{
        super.switchScene(actionEvent, "editEvent.fxml");
    }

}
