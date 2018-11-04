package rmi.interfaces;

import rmi.dto.RoleDTO;

import java.sql.Date;
import java.util.List;

public interface IPersonDTO {

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public Date getDateOfBirth();

    public void setDateOfBirth(Date dateOfBirth);

    public String getUserId();

    public void setUserId(String userId);

    public String getSocialSecurityNumber();

    public void setSocialSecurityNumber(String socialSecurityNumber);

    public int getPersonID();

    public void setPersonID(int personID);

    public List<RoleDTO> getRoleDTOList();

    public void setRoleDTOList(List<RoleDTO> roleDTOList);


}
