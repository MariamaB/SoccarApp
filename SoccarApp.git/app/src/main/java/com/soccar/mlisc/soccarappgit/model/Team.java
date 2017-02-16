package com.soccar.mlisc.soccarappgit.model;

/**
 * Created by mlisc on 16.02.2017.
 */

public class Team {

    private String name;
    private int played;
    private int win;
    private int draw;
    private int loss;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

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
