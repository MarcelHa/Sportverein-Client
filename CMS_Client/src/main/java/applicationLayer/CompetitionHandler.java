package applicationLayer;

import rmi.RMIClient;
import rmi.dto.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class CompetitionHandler {

    public void addNewCompetition(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setCompetitionRemotable().addNewCompetition(competitionDTO);
    }

    public List<CompetitionDTO> getAllCompetitions() throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().getAllCompetitions();
    }

    public CompetitionDTO addTeamsToCompetitionDTO(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().addTeamsToCompetitionDTO(competitionDTO);
    }

    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().getTeamsfromCompetitionDto(competitionDTO);
    }

    public void updateCompetition(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setCompetitionRemotable().updateCompetition(competitionDTO);
    }

    public void insertCompetition(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setCompetitionRemotable().insertCompetition(competitionDTO);
    }

    /*
    Adds or deletes a team from the table view
     */
    public void addTeam(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setCompetitionRemotable().addTeam(competitionDTO);
    }

    public void deleteCompetition(CompetitionDTO competitionDTO) throws RemoteException, NotBoundException, MalformedURLException {
        RMIClient.getInstance().setCompetitionRemotable().deleteCompetition(competitionDTO);
    }

    public List<TeamDTO> getAllTeams()  throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().getAllTeams();
    }

    public List<SportDTO> getAllSports() throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().getAllSports();
    }

    public List<LeagueDTO> getAllLeagues() throws RemoteException, NotBoundException, MalformedURLException {
        return RMIClient.getInstance().setCompetitionRemotable().getAllLeagues();
    }
}
