package com.soccar.mlisc.soccarappgit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mlisc on 16.02.2017.
 */

public class Records {
    @SerializedName("records")
    public List<Team> teamsList;

    public Records(List<Team> team) {
        this.teamsList = team;
    }

    @Override
    public String toString() {
        return "Records{" +
                "teamsList=" + teamsList +
                '}';
    }
}
