package rmi.interfaces;

import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CompetitionRemotable extends Remote {

    void addNewCompetition(CompetitionDTO competition) throws RemoteException;




    public List<CompetitionDTO> getAllCompetitions();

    public CompetitionDTO addTeamsToCompetitionDTO(CompetitionDTO competitionDTO);

    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO);

    public void updateCompetition(CompetitionDTO competitionDTO);

    public void insertCompetition(CompetitionDTO competitionDTO);

    public void addTeam(CompetitionDTO competitionDTO);

    public void deleteCompetition(CompetitionDTO competitionDTO);

    public List<TeamDTO> getAllTeams();


}
