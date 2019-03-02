package com.iteqno.mvvmexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.iteqno.mvvmexample.R;
import com.iteqno.mvvmexample.adapter.TeamBolaAdapter;
import com.iteqno.mvvmexample.model.TeamDetail;
import com.iteqno.mvvmexample.viewmodel.Injection;
import com.iteqno.mvvmexample.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamViewModel.TeamNavigator {

    private TeamViewModel teamViewModel;
    private RecyclerView rvTeam;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> dataListTeamBola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rvTeamBola);
        teamViewModel = new TeamViewModel(Injection.providerTeamRepository(this), this);
        dataListTeamBola = new ArrayList<>();
        teamViewModel.setTeamNavigator(this);
        teamViewModel.getListTeam();
        initAdapter();

    }

    private void initAdapter() {
        adapter = new TeamBolaAdapter(dataListTeamBola);
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        rvTeam.setAdapter(adapter);
        adapter.setData(dataListTeamBola);
    }

    @Override
    public void loadListTeam(List<TeamDetail> listTeam) {
        dataListTeamBola.addAll(listTeam);
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("ERROR", message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
