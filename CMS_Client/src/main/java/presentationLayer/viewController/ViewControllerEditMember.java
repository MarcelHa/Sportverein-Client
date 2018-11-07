package presentationLayer.viewController;

import applicationLayer.MemberHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

            PersonDTO mementoDTO = CareTaker.getMemento();
            initTextField(mementoDTO);

            mementoDTO.setRoleDTOList(_memberHandler.getRolesFromPersonDto(mementoDTO));

            _attachedRolesList = mementoDTO.getRoleDTOList();

            if (_attachedRolesList == null) {
                _attachedRolesList = new LinkedList<>();
            }

            _attachedRolesList = mementoDTO.getRoleDTOList();

            for (RoleDTO role : _attachedRolesList) {
                _availableRolesList.remove(role);
            }

            _availableRoles.refresh();
            _attachedRoles.refresh();

            for (RoleDTO roleDTO : _availableRolesList) {
                if (mementoDTO.getRoleDTOList() != null && mementoDTO.getRoleDTOList().contains(roleDTO)) {
                    _availableRolesList.remove(roleDTO);
                    _attachedRolesList.add(roleDTO);
                }
            }
            _availableRolesObservableList = FXCollections.observableList(_availableRolesList);
            _attachedRolesObservableList = FXCollections.observableList(_attachedRolesList);
            _availableRoles.setItems(_availableRolesObservableList);
            _attachedRoles.setItems(_attachedRolesObservableList);

            utilities.EmptyListeners.Person(firstName, lastName, birthday, ssn);

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
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

        if (utilities.Validation.person(firstName, lastName, birthday, ssn)) {
            super.switchScene(actionEvent, "member.fxml");
            _updatedPersonDTO.setFirstName(firstName.getText());
            _updatedPersonDTO.setLastName(lastName.getText());
            _updatedPersonDTO.setDateOfBirth(toDate(birthday));
            _updatedPersonDTO.setSocialSecurityNumber(ssn.getText());
            _updatedPersonDTO.setRoleDTOList(_attachedRolesList);
            _memberHandler.updateMember(_updatedPersonDTO);
        }
    }


    /*
    Refills the empty text areas with memento
     */
    private void initTextField(PersonDTO mementoDTO) {
        _updatedPersonDTO.setPersonID(mementoDTO.getPersonID());
        firstName.setText(mementoDTO.getFirstName());
        lastName.setText(mementoDTO.getLastName());
        birthday.setValue(UtilDate.convertToLocalDate(mementoDTO.getDateOfBirth()));
        ssn.setText(mementoDTO.getSocialSecurityNumber());
    }

    //Date Converter
    private Date toDate(DatePicker datePicker) {
        return UtilDate.convertToSQLDate(datePicker.getValue());
    }

}






