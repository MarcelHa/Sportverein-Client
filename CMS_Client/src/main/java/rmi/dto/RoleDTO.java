package rmi.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 84984L;
    private int _roleId;
    private String _roleName;

    public int getRoleId() {
        return _roleId;
    }

    public void setRoleId(int roleId) {
        _roleId = roleId;
    }

    public String getRoleName() {
        return _roleName;
    }

    public void setRoleName(String roleName) {
        _roleName = roleName;
    }


    //Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;
        RoleDTO that = (RoleDTO) obj;
        if (this._roleId != that._roleId)
            return false;
        if (!this._roleName.equals(that._roleName))
            return false;
        return true;
    }
}
