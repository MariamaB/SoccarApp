package com.soccar.mlisc.soccarappgit.database;

import android.provider.BaseColumns;

/**
 * Created by mlisc on 21.02.2017.
 */

public class TableData {

    public static abstract class TableInfo implements BaseColumns {

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

    }

    public TableData() {
    }
}
