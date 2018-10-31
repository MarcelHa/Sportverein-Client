package ui.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    public void switchScene(ActionEvent actionEvent, String sceneName) throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
        Scene site = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(site);


    }
}
