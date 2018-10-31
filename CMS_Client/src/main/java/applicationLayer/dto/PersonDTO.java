package applicationLayer.dto;

import java.sql.Date;

public class PersonDTO {

        private String _firstName;
        private String _lastName;
        private Date _dateOfBirth;
        private String _userId;
        private String _socialSecurityNumber;


        public PersonDTO() {

        }

        public PersonDTO(String firstName, String lastName, Date dateOfBirth, String userId, String socialSecurityNumber) {
            _firstName = firstName;
            _lastName = lastName;
            _dateOfBirth = dateOfBirth;
            _userId = userId;
            _socialSecurityNumber = socialSecurityNumber;

        }

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
}
