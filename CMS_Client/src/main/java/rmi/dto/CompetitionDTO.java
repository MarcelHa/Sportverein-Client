package rmi.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class CompetitionDTO implements Serializable {

    private static final long serialVersionUID = 65412L;
    private int _compId;
    private String _compName;
    private String _location;
    private Date _startDate;
    private List<TeamDTO> _teamList;
    private SportDTO _sport;
<<<<<<< HEAD

=======
>>>>>>> a2a78afbcd68097f41a5dfd50ce88d965cc9ca9a

    public String getCompName() {
        return _compName;
    }

    public void setCompName(String compName) {
        _compName = compName;
    }

    public List<TeamDTO> getTeamList() {
        return _teamList;
    }

    public void setTeamList(List<TeamDTO> teamList) {
        _teamList = teamList;
    }

    public CompetitionDTO() { }

    public CompetitionDTO(String location, Date startDate) {
        _location = location;
        _startDate = startDate;
    }

    public String getLocation() { return  _location; }

    public void setLocation(String location) { _location = location; }

    public Date getStartDate() { return  _startDate; }

    public void setStartDate(Date startDate) { _startDate = startDate; }

    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }

    public SportDTO getSport() {
        return _sport;
    }

<<<<<<< HEAD
    public void setSport(SportDTO _sport) {
        _sport = _sport;
    }

=======
    public void setSport(SportDTO sport) { _sport = _sport; }
>>>>>>> a2a78afbcd68097f41a5dfd50ce88d965cc9ca9a
}
