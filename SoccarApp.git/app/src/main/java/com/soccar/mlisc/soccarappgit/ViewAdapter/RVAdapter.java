package com.soccar.mlisc.soccarappgit.ViewAdapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soccar.mlisc.soccarappgit.R;
import com.soccar.mlisc.soccarappgit.model.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mlisc on 19.02.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TeamViewHolder> {

    List<Team> teamList;
    Context context;

    public RVAdapter(List<Team> teamList, Context context) {
        this.context = context;
        this.teamList = teamList;
    }

    @Override
    public RVAdapter.TeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        TeamViewHolder tvh = new TeamViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.TeamViewHolder holder, int position) {

        holder.name.setText(teamList.get(position).getName());
        holder.points.setText(" "+teamList.get(position).getPoints());
        holder.goalsAgainst.setText("Goals against: "+teamList.get(position).getGoalsAgainst());
        holder.goalFor.setText("Goals for: "+teamList.get(position).getGoalsFor());
        holder.draw.setText("Draw: "+teamList.get(position).getDraw());
        holder.loss.setText("Loss: "+teamList.get(position).getLoss());
        holder.win.setText("Win: "+teamList.get(position).getWin());
        holder.played.setText("Played: "+teamList.get(position).getPlayed());

        switch (teamList.get(position).getName()) {
            case "Manchester City":
                Picasso.with(context).load(R.drawable.manchester_city)
                        .placeholder(R.drawable.pl_logo2)
                        .into(holder.logo);
                break;
            case "Arsenal":
                Picasso.with(context).load(R.drawable.arsenal)
                        .into(holder.logo);
                break;
            case "Tottenham":
                Picasso.with(context).load(R.drawable.tottenham_hotspur)
                        .into(holder.logo);
                break;
            case "Leicester":
                Picasso.with(context).load(R.drawable.leicester_city)
                        .into(holder.logo);
                break;
            case "Manchester United":
                Picasso.with(context).load(R.drawable.manchester_united)
                        .into(holder.logo);
                break;
            case "West Ham":
                Picasso.with(context).load(R.drawable.west_ham)
                        .into(holder.logo);
                break;
            case "Liverpool":
                Picasso.with(context).load(R.drawable.liverpool)
                        .into(holder.logo);
                break;
            case "Norwich":
                Picasso.with(context).load(R.drawable.norwich_city)
                        .into(holder.logo);
                break;
            case "Southampton":
                Picasso.with(context).load(R.drawable.southampton_fc)
                        .into(holder.logo);
                break;
            case "Chelsea":
                Picasso.with(context).load(R.drawable.chelsea)
                        .into(holder.logo);
                break;
            case "West Bromwich Albion":
                Picasso.with(context).load(R.drawable.west_bromwich_albion)
                        .into(holder.logo);
                break;
            case "Crystal Palace":
                Picasso.with(context).load(R.drawable.crystal_palace_fc)
                        .into(holder.logo);
                break;
            case "Watford":
                Picasso.with(context).load(R.drawable.watford_fc)
                        .into(holder.logo);
                break;
            case "Stoke":
                Picasso.with(context).load(R.drawable.stoke_city)
                        .into(holder.logo);
                break;
            case "Swansea":
                Picasso.with(context).load(R.drawable.swansea_city_afc)
                        .into(holder.logo);
                break;
            case "Everton":
                Picasso.with(context).load(R.drawable.everton_fc)
                        .into(holder.logo);
                break;
            case "Sunderland":
                Picasso.with(context).load(R.drawable.sunderland)
                        .into(holder.logo);
                break;
            case "Bournemouth":
                Picasso.with(context).load(R.drawable.afc_bournemouth)
                        .into(holder.logo);
                break;
            case "Newcastle United":
                Picasso.with(context).load(R.drawable.manchester_united)
                        .into(holder.logo);
                break;
            case "Aston Villa":
                Picasso.with(context).load(R.drawable.aston_villa)
                        .into(holder.logo);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        CardView cv2;

        TextView name;
        TextView played;
        TextView win;
        TextView draw;
        TextView loss;
        TextView goalFor;
        TextView goalsAgainst;
        TextView points;
        ImageView logo;

        public TeamViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv);
            cv2 = (CardView) itemView.findViewById(R.id.cv2);

            name = (TextView) itemView.findViewById(R.id.teamName);
            played = (TextView) itemView.findViewById(R.id.played);
            win = (TextView) itemView.findViewById(R.id.win);
            draw = (TextView) itemView.findViewById(R.id.draw);
            loss = (TextView) itemView.findViewById(R.id.los);
            goalFor = (TextView) itemView.findViewById(R.id.goalsFor);
            goalsAgainst = (TextView) itemView.findViewById(R.id.goalsAgainst);
            points = (TextView) itemView.findViewById(R.id.points);
            logo = (ImageView) itemView.findViewById(R.id.teamLogo);


        }


    }
}
