package com.iteqno.mvvmexample.data;

import com.iteqno.mvvmexample.model.Team;

public interface TeamDataSource {

    void getListTeams(GetTeamsCallback callback);

    interface GetTeamsCallback {
        void onTeamLoaded(Team data);
        void onDataNotAvailable(String errorMassage);
    }
}
