package rmi.interfaces;

import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CompetitionRemotable extends Remote {

    void addNewCompetition(CompetitionDTO competition) throws RemoteException;




    public List<CompetitionDTO> getAllCompetitions()  throws RemoteException;;

    public CompetitionDTO addTeamsToCompetitionDTO(CompetitionDTO competitionDTO)  throws RemoteException;;

    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO)  throws RemoteException;;

    public void updateCompetition(CompetitionDTO competitionDTO)  throws RemoteException;;

    public void insertCompetition(CompetitionDTO competitionDTO)  throws RemoteException;;

    public void addTeam(CompetitionDTO competitionDTO)  throws RemoteException;;

    public void deleteCompetition(CompetitionDTO competitionDTO)  throws RemoteException;;

    public List<TeamDTO> getAllTeams()  throws RemoteException;;


}
