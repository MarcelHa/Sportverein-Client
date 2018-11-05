package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import rmi.dto.PersonDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentationLayer.SceneController;
import rmi.dto.RoleDTO;
import utilities.UtilDate;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.*;


public class ViewControllerNewMember extends SceneController implements Initializable {

    @FXML
    Button addMember;
    @FXML
    TextField firstName, lastName, ssn;
    @FXML
    DatePicker birthday;

    @FXML
    private Button _giveRole;

    @FXML
    private Button _deleteRole;

    @FXML
    private TableView<RoleDTO> _availableRoles;

    @FXML
    private TableView<RoleDTO> _attachedRoles;

    private List<RoleDTO> _availableRolesList;

    private ObservableList<RoleDTO> _availableRolesObservableList;

    private ObservableList<RoleDTO> _attachedRolesObservableList;

    private List<RoleDTO> _attachedRolesList = new LinkedList<RoleDTO>();


    private MemberHandler _memberHandler = new MemberHandler();


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
    public void switchToHome(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "home.fxml");
    }

    @FXML
    public void switchToResult(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "result.fxml");
    }

    @FXML
    public void switchToEditMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "editMember.fxml");
    }

    @FXML
    public void switchToMemberList(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "memberList.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            _availableRolesList = _memberHandler.getAllRoles();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        _availableRolesObservableList = FXCollections.observableList(_availableRolesList);

        _attachedRolesObservableList = FXCollections.observableList(_attachedRolesList);

        _availableRoles.setItems(_availableRolesObservableList);

        _attachedRoles.setItems(_attachedRolesObservableList);
    }

    /*
    Presentation Layer Logic
     */
    @FXML
    public void addRole() {
        if (_availableRolesList.remove(_availableRoles.getSelectionModel().getSelectedItem())) {
            _attachedRolesList.add(_availableRoles.getSelectionModel().getSelectedItem());
        }
        _availableRoles.refresh();
        _attachedRoles.refresh();
    }

    @FXML
    public void deleteRole() {
        if (_attachedRolesList.remove(_attachedRoles.getSelectionModel().getSelectedItem())) {
            _availableRolesList.add(_attachedRoles.getSelectionModel().getSelectedItem());
        }
        _availableRoles.refresh();
        _attachedRoles.refresh();
    }


    @FXML
    public void addNewMember(ActionEvent actionEvent) throws IOException, NotBoundException {
        super.switchScene(actionEvent, "Member.fxml");
        PersonDTO person = new PersonDTO();
        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setDateOfBirth(toDate(birthday));
        person.setSocialSecurityNumber(ssn.getText());
        person.setRoleDTOList(_attachedRolesList);
        _memberHandler.addNewMember(person);



    }

    //Date Converter
    private Date toDate(DatePicker datePicker) {
        return UtilDate.convertToSQLDate(datePicker.getValue());
    }


}
