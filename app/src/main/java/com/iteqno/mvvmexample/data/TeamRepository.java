package com.iteqno.mvvmexample.data;

import com.iteqno.mvvmexample.data.local.TeamLocalDataSource;
import com.iteqno.mvvmexample.data.remote.TeamRemoteDataSource;
import com.iteqno.mvvmexample.model.Team;

public class TeamRepository implements TeamDataSource {

    private TeamRemoteDataSource teamRemoteDataSource;
    private TeamLocalDataSource teamLocalDataSource;

    public TeamRepository(TeamRemoteDataSource teamRemoteDataSource, TeamLocalDataSource teamLocalDataSource) {
        this.teamRemoteDataSource = teamRemoteDataSource;
        this.teamLocalDataSource = teamLocalDataSource;
    }

    public void getTeamsFromRemote(final GetTeamsCallback callback) {

        teamRemoteDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                // Insert data
                teamLocalDataSource.saveDataTeam(data.getTeams());
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMassage) {
                callback.onDataNotAvailable(errorMassage);
            }
        });
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        teamLocalDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMassage) {
                getTeamsFromRemote(callback);
            }
        });
    }
}
