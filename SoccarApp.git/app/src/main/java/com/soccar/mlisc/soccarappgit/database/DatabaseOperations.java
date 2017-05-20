package com.soccar.mlisc.soccarappgit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.soccar.mlisc.soccarappgit.model.Team;

/**
 * Created by mlisc on 21.02.2017.
 */

public class DatabaseOperations extends OrmLiteSqliteOpenHelper {

    public static final String database_name = "soccar_app.db";
    public static final int database_version = 1;

    private Dao<Team, Integer> teamDao = null;


    public DatabaseOperations(Context context) {
        super(context, database_name, null, database_version);
        Log.d("Database Operations","Created Database");
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Team.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        Log.d("Database Operations","Created Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }


    public Dao<Team, Integer> getTeamDao() throws java.sql.SQLException {
        if (teamDao == null) {
            teamDao = getDao(Team.class);
        }

        return teamDao;
    }

    public void productClose() {
        teamDao = null;

        super.close();
    }
}
