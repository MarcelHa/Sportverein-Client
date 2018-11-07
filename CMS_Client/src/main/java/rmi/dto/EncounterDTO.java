package rmi.dto;


public class EncounterDTO {
    private int _encounterId;
    private int _resultId;
    private int _team1Id;
    private int _team2Id;

    public int getEncounterId() {
        return _encounterId;
    }

    public void setEncounterId(int encounterId) {
        _encounterId = encounterId;
    }

    public int getResultId() {
        return _resultId;
    }

    public void setResultId(int resultId) {
        _resultId = resultId;
    }

    public int getTeam1Id() {
        return _team1Id;
    }

    public void setTeam1Id(int team1Id) {
        _team1Id = team1Id;
    }

    public int getTeam2Id() {
        return _team2Id;
    }

    public void setTeam2Id(int team2Id) {
        _team2Id = team2Id;
    }

}