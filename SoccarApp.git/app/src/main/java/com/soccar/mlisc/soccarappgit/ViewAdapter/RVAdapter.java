package com.soccar.mlisc.soccarappgit.ViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mlisc on 19.02.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TeamViewHolder> {
    @Override
    public RVAdapter.TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RVAdapter.TeamViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{
        String name;
        String played;
        String win;
        String draw;
        String loss;
        String goalFor;
        String goalsAgainst;
        String points;

        public TeamViewHolder(View itemView) {
            super(itemView);
        }


    }
}
