package rmi.dto;

import java.io.Serializable;

public class LeagueDTO implements Serializable {

    private static final long serialVersionUID = 65486L;

    private int _leagueID;
    private String _leagueName;


    public String getLeagueName() {
        return _leagueName;
    }

    public void setLeagueName(String leagueName) {
        _leagueName = leagueName;
    }

    public int getLeagueID() {
        return _leagueID;
    }

    public void setLeagueID(int leagueID) {
        _leagueID = leagueID;
    }
}
