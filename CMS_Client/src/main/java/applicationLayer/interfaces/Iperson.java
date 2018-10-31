package applicationLayer.interfaces;

import java.util.Date;

public interface Iperson {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    String getUserId();

    void setUserId(String userId);

    String getSocialSecurityNumber();

    void setSocialSecurityNumber(String socialSecurityNumber);


}