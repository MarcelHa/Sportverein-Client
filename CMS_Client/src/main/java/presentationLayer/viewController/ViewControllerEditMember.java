package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import presentationLayer.CareTaker;
import presentationLayer.SceneController;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;
import utilities.UtilDate;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.*;

public class ViewControllerEditMember extends SceneController implements Initializable {

    @FXML
    private TextField firstName, lastName, ssn;
    @FXML
    private DatePicker birthday;
    @FXML
    private TableView<RoleDTO> _availableRoles;
    @FXML
    private TableView<RoleDTO> _attachedRoles;


    private PersonDTO _updatedPersonDTO = new PersonDTO();
    private List<RoleDTO> _availableRolesList;
    private ObservableList<RoleDTO> _availableRolesObservableList;
    private ObservableList<RoleDTO> _attachedRolesObservableList;
    private List<RoleDTO> _attachedRolesList = new LinkedList<RoleDTO>();
    private MemberHandler _memberHandler = new MemberHandler();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            _availableRolesList = _memberHandler.getAllRoles();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        PersonDTO mementoDTO = CareTaker.getMemento();
        initTextField(mementoDTO);

        try {
            mementoDTO.setRoleDTOList(_memberHandler.getRolesFromPersonDto(mementoDTO));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        _attachedRolesList = mementoDTO.getRoleDTOList();

        for (RoleDTO role:_attachedRolesList) {
            _availableRolesList.remove(role);
        }

        _availableRoles.refresh();
        _attachedRoles.refresh();


        for (RoleDTO roleDTO:_availableRolesList) {
            for (RoleDTO roleDTOMemento:mementoDTO.getRoleDTOList()) {
                if (roleDTOMemento.getRoleId() == roleDTO.getRoleId()) {
                    _availableRolesList.remove(roleDTO);
                }
            }
        }

        if (_attachedRolesList == null) {
            _attachedRolesList = new LinkedList<RoleDTO>();
        }

        _availableRolesObservableList = FXCollections.observableList(_availableRolesList);
        _attachedRolesObservableList = FXCollections.observableList(_attachedRolesList);
        _availableRoles.setItems(_availableRolesObservableList);
        _attachedRoles.setItems(_attachedRolesObservableList);

        utilities.EmptyListeners.Person(firstName, lastName, birthday, ssn);

    }


    /*
    Simple Dashboard Navigation
     */
    @FXML
    public void switchToMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "member.fxml");
    }
    @FXML
    public void switchToNewMember(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "newMember.fxml");
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
    public void switchToMemberList(ActionEvent actionEvent) throws IOException {
        super.switchScene(actionEvent, "memberList.fxml");
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
    public void updateMember(ActionEvent actionEvent) throws IOException, NotBoundException {
        if (utilities.Validation.person(firstName,lastName,birthday,ssn)) {

            super.switchScene(actionEvent, "member.fxml");
            _updatedPersonDTO.setFirstName(firstName.getText());
            _updatedPersonDTO.setLastName(lastName.getText());
            _updatedPersonDTO.setDateOfBirth(toDate(birthday));
            _updatedPersonDTO.setSocialSecurityNumber(ssn.getText());
            _updatedPersonDTO.setRoleDTOList(_attachedRolesList);
            _memberHandler.updateMember(_updatedPersonDTO);
        }
    }

    //Date Converter
    private Date toDate(DatePicker datePicker) {
        return UtilDate.convertToSQLDate(datePicker.getValue());
    }

    private void initTextField(PersonDTO mementoDTO){
        _updatedPersonDTO.setPersonID(mementoDTO.getPersonID());
        firstName.setText(mementoDTO.getFirstName());
        lastName.setText(mementoDTO.getLastName());
        //TODO
        birthday.setValue(UtilDate.convertToLocalDate(mementoDTO.getDateOfBirth()));
        ssn.setText(mementoDTO.getSocialSecurityNumber());
    }


}





