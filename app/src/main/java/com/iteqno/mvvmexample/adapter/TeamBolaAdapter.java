package com.iteqno.mvvmexample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteqno.mvvmexample.R;
import com.iteqno.mvvmexample.model.TeamDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.ViewHolder> {

    private List<TeamDetail> teams;

    public TeamBolaAdapter(List<TeamDetail> team) {
        this.teams = team;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.teamName.setText(teams.get(i).teamName);
        Picasso.get().load(teams.get(i).teamLogo).into(viewHolder.teamLogo);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void setData(List<TeamDetail> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView teamName;
        private ImageView teamLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.teamName);
            teamLogo = itemView.findViewById(R.id.teamLogo);
        }
    }
}
