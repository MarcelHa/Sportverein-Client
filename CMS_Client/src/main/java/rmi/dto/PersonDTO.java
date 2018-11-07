package rmi.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 12458L;

    private int personID;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private String _userId;
    private String _socialSecurityNumber;
    private List<RoleDTO> _roleDTOList;


//    public PersonDTO() {
//
//    }

    /*
    public PersonDTO(String firstName, String lastName, Date dateOfBirth, String userId, String socialSecurityNumber) {
        _firstName = firstName;
        _lastName = lastName;
        _dateOfBirth = dateOfBirth;
        _userId = userId;
        _socialSecurityNumber = socialSecurityNumber;
    }
    */

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public Date getDateOfBirth() {
        return _dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        _dateOfBirth = dateOfBirth;
    }

    public String getUserId() {
        return _userId;
    }

    public void setUserId(String userId) {
        _userId = userId;
    }

    public String getSocialSecurityNumber() {
        return _socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        _socialSecurityNumber = socialSecurityNumber;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public List<RoleDTO> getRoleDTOList() {
        return _roleDTOList;
    }

    public void setRoleDTOList(List<RoleDTO> roleDTOList) {
        _roleDTOList = roleDTOList;
    }
}
