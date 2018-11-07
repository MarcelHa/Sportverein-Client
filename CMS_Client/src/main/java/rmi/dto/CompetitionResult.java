package rmi.dto;



public class CompetitionResult {
    private int _points;
    private CompetitionDTO _competitionDTO;
    private TeamDTO _teamDTO;

    public int getPoints() {
        return _points;
    }

    public void setPoints(int points) {
        _points = points;
    }

    public CompetitionDTO getCompetitionDTO() {
        return _competitionDTO;
    }

    public void setCompetitionDTO(CompetitionDTO competitionDTO) {
        _competitionDTO = competitionDTO;
    }

    public TeamDTO getTeamDTO() {
        return _teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        _teamDTO = teamDTO;
    }
}
