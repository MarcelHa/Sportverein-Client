package rmi.dto;

import java.util.List;

public class LineUpDTO {
    private int _personId;
    private int _teamId;
    private int _compId;
    private List<PersonDTO> _personByPersonId;
    private TeamDTO _internalTeamByTeamId;
    private CompetitionDTO _competitionByCompId;
}
