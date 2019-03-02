package com.iteqno.mvvmexample.viewmodel;

import android.content.Context;

import com.iteqno.mvvmexample.data.TeamRepository;
import com.iteqno.mvvmexample.data.local.TeamLocalDataSource;
import com.iteqno.mvvmexample.data.remote.TeamRemoteDataSource;

public class Injection {

    public static TeamRepository providerTeamRepository(Context context) {
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource(context));
    }
}
