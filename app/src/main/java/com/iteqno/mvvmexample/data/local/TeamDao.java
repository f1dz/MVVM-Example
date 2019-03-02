package com.iteqno.mvvmexample.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.iteqno.mvvmexample.model.TeamDetail;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM team")
    List<TeamDetail> getTeams();

    @Insert
    void insertTeams(List<TeamDetail> teams);
}
