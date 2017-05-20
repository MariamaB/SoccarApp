package com.soccar.mlisc.soccarappgit.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mlisc on 16.02.2017.
 */
@DatabaseTable(tableName = Team.table_name_teamTable, daoClass = BaseDaoImpl.class)
public class Team {

    public static final String table_name_teamTable = "teamTable";

    public static final String t_id = "t_id";
    public static final String t_name = "t_name";
    public static final String t_played = "t_played";
    public static final String t_win = "t_win";
    public static final String t_draw = "t_draw";
    public static final String t_loss = "t_loss";
    public static final String t_goals_for = "t_goals_for";
    public static final String t_goals_against = "t_goals_against";
    public static final String t_points = "t_points";


    @DatabaseField (columnName= t_id, generatedId= true)
    private int id;

    @SerializedName("team")
    @DatabaseField(columnName = t_name)
    private String name;
    @DatabaseField(columnName = t_played)
    private int played;
    @DatabaseField(columnName = t_win)
    private int win;
    @DatabaseField(columnName = t_draw)
    private int draw;
    @DatabaseField(columnName = t_loss)
    private int loss;
    @DatabaseField(columnName = t_goals_for)
    private int goalsFor;
    @DatabaseField(columnName = t_goals_against)
    private int goalsAgainst;
    @DatabaseField(columnName = t_points)
    private int points;



    public Team() {
    }


    public Team(String name, int played, int win, int draw, int loss, int goalsFor, int goalsAgainst, int points) {
        this.name = name;
        this.played = played;
        this.win = win;
        this.draw = draw;
        this.loss = loss;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.points = points;
    }


    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWin() {
        return win;
    }

    public int getDraw() {
        return draw;
    }

    public int getLoss() {
        return loss;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", played=" + played +
                ", win=" + win +
                ", draw=" + draw +
                ", loss=" + loss +
                ", goalsFor=" + goalsFor +
                ", goalsAgainst=" + goalsAgainst +
                ", points=" + points +
                '}';
    }
}
