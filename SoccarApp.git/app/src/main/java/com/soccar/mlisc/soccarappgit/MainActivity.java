package com.soccar.mlisc.soccarappgit;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.soccar.mlisc.soccarappgit.ViewAdapter.RVAdapter;
import com.soccar.mlisc.soccarappgit.database.DatabaseOperations;
import com.soccar.mlisc.soccarappgit.model.Records;
import com.soccar.mlisc.soccarappgit.model.Team;

import java.sql.SQLException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        this.RetrofitRequest();

        DatabaseOperations helper = OpenHelperManager.getHelper(this, DatabaseOperations.class);

        try {
            Dao<Team, Integer> teamdao = helper.getTeamDao();
            List<Team> teamList = teamdao.queryForAll();
            if(teamList == null){
                restControllerRequest();

            }
            Log.d("Database call ", teamList.toString());
            RVAdapter rvAdapter = new RVAdapter(teamList, this);
            rv.setAdapter(rvAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private void insertData(List<Team> teamList) {
//            this.deleteDatabase("soccar_app.db");
            Team team;

            DatabaseOperations db = new DatabaseOperations(this);
            Dao<Team, Integer> teamDao = null;

            try {
                teamDao = db.getTeamDao();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < teamList.size(); i++) {
                team = teamList.get(i);
                try {
                    teamDao.create(team);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            Toast.makeText(getBaseContext(), "Data was inserted", Toast.LENGTH_LONG).show();
            Log.d("InsertData() ", "Data was inserted");
        }

    public void RetrofitRequest() {
        String BASE_URL = "https://heisenbug-premier-league-live-scores-v1.p.mashape.com";
        Retrofit retrofit = null;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        TableRequestService service = retrofit.create(TableRequestService.class);

        Call<Records> teamTabelCall = service.getTeams("GIuHYh8MiBmshEyEHYblQyxd4kuOp1vPkZAjsn9K8Wjr4ebNxY", "application/json");

        teamTabelCall.enqueue(new retrofit2.Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                List<Team> teamsList;
                teamsList = (List<Team>) response.body().teamsList;
//                insertData(teamsList);
//                for(int i = 0; i < teamsList.size(); i++){
//                    Log.d("ResponseBody LIST: ",teamsList.get(i).toString());
//                }
            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {
                System.out.println("Failurrrrree!!!: " + t);
            }
        });
    }

    public void restControllerRequest() {

        String BASE_URL = "http://192.168.2.111:8085";
        Retrofit retrofit = null;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        TableRequestService service = retrofit.create(TableRequestService.class);

        Call<Records> teamTabelCall = service.getTeamByRest();
        teamTabelCall.enqueue(new retrofit2.Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                List<Team> teamsList;
                teamsList = (List<Team>) response.body().teamsList;
//                insertData(teamsList);
                Log.d("ResponseBody: ",teamsList.toString());

            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {
                System.out.println("Failurrrrree!!!: " + t);
            }
        });
    }

    public interface TableRequestService {

        @GET("/api/premierleague/table?mode=home&season=2016-17")
        Call<Records> getTeams(@Header("X-Mashape-Key") String key, @Header("Accept") String accept);

        @GET("/t")
        Call<Records> getTeamByRest();
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
