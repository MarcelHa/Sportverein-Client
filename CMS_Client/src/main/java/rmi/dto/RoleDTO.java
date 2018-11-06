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
}
