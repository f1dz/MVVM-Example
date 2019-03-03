package com.iteqno.mvvmexample.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iteqno.mvvmexample.R;
import com.iteqno.mvvmexample.databinding.ItemRowBinding;
import com.iteqno.mvvmexample.model.TeamDetail;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.ViewHolder> {

    private List<TeamDetail> teams;
    private LayoutInflater layoutInflater;

    public TeamBolaAdapter(List<TeamDetail> team) {
        this.teams = team;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        ItemRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_row, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.setTeamDetailVM(teams.get(i));
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

        private final ItemRowBinding binding;

        public ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }
    }
}
