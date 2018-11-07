package rmi.dto;

import java.io.Serializable;

public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 84846L;

    private int _teamID;
    private String _teamName;
    private SportDTO _sportDTO;
    private LeagueDTO _leagueDTO;

    public TeamDTO() { }

    public TeamDTO(int teamID) {
        _teamID = teamID;
    }

    public String getTeamName() {
        return _teamName;
    }

    public void setTeamName(String teamName) {
        _teamName = teamName;
    }

    public SportDTO getSportDTO() {
        return _sportDTO;
    }

    public void setSportDTO(SportDTO sportDTO) {
        _sportDTO = sportDTO;
    }

    public LeagueDTO getLeagueDTO() {
        return _leagueDTO;
    }

    public void setLeagueDTO(LeagueDTO leagueDTO) {
        _leagueDTO = leagueDTO;
    }

    public int getTeamID() {
        return _teamID;
    }

    public void setTeamID(int teamID) {
        _teamID = teamID;
    }
}
