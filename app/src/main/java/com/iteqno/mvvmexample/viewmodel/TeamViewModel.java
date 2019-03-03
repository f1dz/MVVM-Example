package com.iteqno.mvvmexample.viewmodel;

import android.content.Context;

import com.iteqno.mvvmexample.data.TeamDataSource;
import com.iteqno.mvvmexample.data.TeamRepository;
import com.iteqno.mvvmexample.model.Team;
import com.iteqno.mvvmexample.model.TeamDetail;

import java.util.List;

public class TeamViewModel {

    private TeamRepository teamRepository;
    private TeamNavigator teamNavigator;

    public TeamViewModel(TeamRepository teamRepository, Context context) {
        this.teamRepository = teamRepository;
    }

    public void setTeamNavigator(TeamNavigator teamNavigator) {
        this.teamNavigator = teamNavigator;
    }

    public void getListTeam() {
        teamRepository.getListTeams(new TeamDataSource.GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String errorMassage) {
                teamNavigator.errorLoadListTeam(errorMassage);
            }
        });
    }

    public interface TeamNavigator{
        void loadListTeam(List<TeamDetail> listTeam);
        void errorLoadListTeam(String message);
    }
}
