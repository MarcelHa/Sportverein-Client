package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import presentationLayer.SceneController;

import javafx.scene.control.TableView;
import rmi.dto.PersonDTO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;


public class ViewControllerEditMember extends  SceneController  implements Initializable {


    @FXML
    private TableView<PersonDTO> _membersTableView;
    private MemberHandler _memberHandler = new MemberHandler();
    private List<PersonDTO> _personDTOList;
    private ObservableList<PersonDTO> _personDTOObservableListList;

    public ViewControllerEditMember() throws RemoteException, NotBoundException, MalformedURLException {
    }

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
    public void switchToNewMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "newMember.fxml");
    }





    /*
    Presentation Layer Logic
     */

    @Override
    public void initialize(URL location, ResourceBundle resources)  {



        try {
            _personDTOList = _memberHandler.getAllMember();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        _personDTOObservableListList = FXCollections.observableList(_personDTOList);

        _membersTableView.setItems(_personDTOObservableListList);

    }



}
