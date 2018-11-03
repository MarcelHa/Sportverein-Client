package rmi.dto;

import java.io.Serializable;
import java.sql.Date;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 7181607601291344700L;

    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private String _userId;
    private String _socialSecurityNumber;
    private int _personID;


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
        return _personID;
    }

    public void setPersonID(int _personId) {
        this._personID = _personId;
    }
}
