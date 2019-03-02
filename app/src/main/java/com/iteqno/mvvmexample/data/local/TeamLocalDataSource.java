package com.iteqno.mvvmexample.data.local;

import android.content.Context;

import com.iteqno.mvvmexample.data.TeamDataSource;
import com.iteqno.mvvmexample.model.Team;
import com.iteqno.mvvmexample.model.TeamDetail;

import java.util.List;

public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDao teamDao;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        teamDao = TeamDatabase.getInstance(context).teamDao();
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> team = teamDao.getTeams();
                if(team.isEmpty()) {
                    callback.onDataNotAvailable("Data di database SQLite kosong");
                } else {
                    Team teams = new Team(team);
                    callback.onTeamLoaded(teams);
                }
            }
        };

        new Thread(runnable).start();
    }

    public void saveDataTeam(final List<TeamDetail> teamDetails) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDao.insertTeams(teamDetails);
            }
        };

        new Thread(runnable).start();
    }
}
