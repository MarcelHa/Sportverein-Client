package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentationLayer.SceneController;
import rmi.dto.PersonDTO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;


public class ViewControllerMemberList extends  SceneController  implements Initializable {


    @FXML
    private TableView<PersonDTO> _membersTableView;

    @FXML
    private TextField _filterField;





    private MemberHandler _memberHandler = new MemberHandler();
    private List<PersonDTO> _personDTOList;
    private ObservableList<PersonDTO> _personDTOObservableListList;



    public ViewControllerMemberList() throws RemoteException, NotBoundException, MalformedURLException {
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



        FilteredList<PersonDTO> filteredData = new FilteredList<>(_personDTOObservableListList, p -> true);

        _filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getFirstName() != null && person.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getLastName() != null && person.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getSocialSecurityNumber() != null && person.getSocialSecurityNumber().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getUserId() != null && person.getUserId().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        SortedList<PersonDTO> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(_membersTableView.comparatorProperty());

        _membersTableView.setItems(sortedData);

    }


    @FXML
    public void editMember() {

    }

    @FXML
    public void deleteMember(ActionEvent actionEvent) throws IOException, NotBoundException {
        _memberHandler.deleteMember(_membersTableView.getSelectionModel().getSelectedItem());
        super.switchScene(actionEvent, "Member.fxml");

    }


}
