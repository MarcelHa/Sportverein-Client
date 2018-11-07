package rmi.interfaces;

import rmi.dto.CompetitionDTO;
import rmi.dto.LeagueDTO;
import rmi.dto.SportDTO;
import rmi.dto.TeamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CompetitionRemotable extends Remote {

    void addNewCompetition(CompetitionDTO competition) throws RemoteException;

    List<CompetitionDTO> getAllCompetitions()  throws RemoteException;

    CompetitionDTO addTeamsToCompetitionDTO(CompetitionDTO competitionDTO)  throws RemoteException;

    List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO)  throws RemoteException;

    void updateCompetition(CompetitionDTO competitionDTO)  throws RemoteException;

    void insertCompetition(CompetitionDTO competitionDTO)  throws RemoteException;

    void addTeam(CompetitionDTO competitionDTO)  throws RemoteException;

    void deleteCompetition(CompetitionDTO competitionDTO)  throws RemoteException;

    List<TeamDTO> getAllTeams()  throws RemoteException;;

    List<SportDTO> getAllSports() throws RemoteException;

    List<LeagueDTO> getAllLeagues() throws RemoteException;
}
