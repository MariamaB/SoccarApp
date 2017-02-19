package com.soccar.mlisc.soccarappgit.requests;

import com.soccar.mlisc.soccarappgit.model.Records;
import com.soccar.mlisc.soccarappgit.model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by mlisc on 17.02.2017.
 */

public class SoccarRequests {

    public SoccarRequests() {
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
//               try {
                   teamsList = (List<Team>) response.body().teamsList;
//               }
//               catch (RuntimeException e){
//                   teamsList = [
//                   {
//                       "team": "Manchester City",
//                           "played": 10,
//                           "win": 8,
//                           "draw": 0,
//                           "loss": 2,
//                           "goalsFor": 29,
//                           "goalsAgainst": 12,
//                           "points": 24
//                   },
//                   {
//                       "team": "Arsenal",
//                           "played": 10,
//                           "win": 7,
//                           "draw": 2,
//                           "loss": 1,
//                           "goalsFor": 16,
//                           "goalsAgainst": 6,
//                           "points": 23
//                   },
//                   {
//                       "team": "Tottenham",
//                           "played": 10,
//                           "win": 5,
//                           "draw": 4,
//                           "loss": 1,
//                           "goalsFor": 18,
//                           "goalsAgainst": 7,
//                           "points": 19
//                   },
//                   {
//                       "team": "Leicester",
//                           "played": 10,
//                           "win": 5,
//                           "draw": 4,
//                           "loss": 1,
//                           "goalsFor": 16,
//                           "goalsAgainst": 13,
//                           "points": 19
//                   },
//                   {
//                       "team": "Manchester United",
//                           "played": 10,
//                           "win": 5,
//                           "draw": 4,
//                           "loss": 1,
//                           "goalsFor": 12,
//                           "goalsAgainst": 4,
//                           "points": 19
//                   },
//                   {
//                       "team": "West Ham",
//                           "played": 10,
//                           "win": 4,
//                           "draw": 4,
//                           "loss": 2,
//                           "goalsFor": 16,
//                           "goalsAgainst": 12,
//                           "points": 16
//                   },
//                   {
//                       "team": "Liverpool",
//                           "played": 9,
//                           "win": 4,
//                           "draw": 3,
//                           "loss": 2,
//                           "goalsFor": 11,
//                           "goalsAgainst": 11,
//                           "points": 15
//                   },
//                   {
//                       "team": "Norwich",
//                           "played": 10,
//                           "win": 4,
//                           "draw": 3,
//                           "loss": 3,
//                           "goalsFor": 12,
//                           "goalsAgainst": 10,
//                           "points": 15
//                   },
//                   {
//                       "team": "Southampton",
//                           "played": 10,
//                           "win": 4,
//                           "draw": 2,
//                           "loss": 4,
//                           "goalsFor": 17,
//                           "goalsAgainst": 13,
//                           "points": 14
//                   },
//                   {
//                       "team": "Chelsea",
//                           "played": 10,
//                           "win": 4,
//                           "draw": 2,
//                           "loss": 4,
//                           "goalsFor": 15,
//                           "goalsAgainst": 14,
//                           "points": 14
//                   },
//                   {
//                       "team": "West Bromwich Albion",
//                           "played": 11,
//                           "win": 4,
//                           "draw": 2,
//                           "loss": 5,
//                           "goalsFor": 14,
//                           "goalsAgainst": 17,
//                           "points": 14
//                   },
//                   {
//                       "team": "Crystal Palace",
//                           "played": 11,
//                           "win": 4,
//                           "draw": 2,
//                           "loss": 5,
//                           "goalsFor": 12,
//                           "goalsAgainst": 12,
//                           "points": 14
//                   },
//                   {
//                       "team": "Watford",
//                           "played": 11,
//                           "win": 4,
//                           "draw": 2,
//                           "loss": 5,
//                           "goalsFor": 11,
//                           "goalsAgainst": 10,
//                           "points": 14
//                   },
//                   {
//                       "team": "Stoke",
//                           "played": 9,
//                           "win": 4,
//                           "draw": 1,
//                           "loss": 4,
//                           "goalsFor": 10,
//                           "goalsAgainst": 9,
//                           "points": 13
//                   },
//                   {
//                       "team": "Swansea",
//                           "played": 10,
//                           "win": 3,
//                           "draw": 4,
//                           "loss": 3,
//                           "goalsFor": 9,
//                           "goalsAgainst": 12,
//                           "points": 13
//                   },
//                   {
//                       "team": "Everton",
//                           "played": 11,
//                           "win": 3,
//                           "draw": 4,
//                           "loss": 4,
//                           "goalsFor": 23,
//                           "goalsAgainst": 20,
//                           "points": 13
//                   },
//                   {
//                       "team": "Sunderland",
//                           "played": 10,
//                           "win": 3,
//                           "draw": 2,
//                           "loss": 5,
//                           "goalsFor": 12,
//                           "goalsAgainst": 11,
//                           "points": 11
//                   },
//                   {
//                       "team": "Bournemouth",
//                           "played": 9,
//                           "win": 2,
//                           "draw": 4,
//                           "loss": 3,
//                           "goalsFor": 10,
//                           "goalsAgainst": 13,
//                           "points": 10
//                   },
//                   {
//                       "team": "Newcastle United",
//                           "played": 10,
//                           "win": 2,
//                           "draw": 4,
//                           "loss": 4,
//                           "goalsFor": 14,
//                           "goalsAgainst": 14,
//                           "points": 10
//                   },
//                   {
//                       "team": "Aston Villa",
//                           "played": 9,
//                           "win": 0,
//                           "draw": 3,
//                           "loss": 6,
//                           "goalsFor": 6,
//                           "goalsAgainst": 13,
//                           "points": 3
//                   }
//                   ];
//               }





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
    }
}
