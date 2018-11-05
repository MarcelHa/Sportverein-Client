package rmi.dto;

import java.io.Serializable;

public class SportDTO implements Serializable {
    private static final long serialVersionUID = 65486846;
    public String getSportName() {
        return _sportName;
    }

    public void setSportName(String sportName) {
        _sportName = sportName;
    }

    public int getSportId() {
        return _sportId;
    }

    public void setSportId(int sportId) {
        _sportId = sportId;
    }

    private int _sportId;
    private String _sportName;
    private int _deptId;


}
