package net.backwings.cinex.Utils;

import net.backwings.cinex.Models.MovieDatabase;
import net.backwings.cinex.Models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mukul on 1/25/2018.
 */

public final class GetArrayListFromJson {

    private static ArrayList<MovieModel> ar;

    public static ArrayList<MovieModel> getList(String JSON)
    {

        try {
            JSONObject jsonObject= new JSONObject(JSON);
            JSONArray jsonArray= jsonObject.getJSONArray(MovieDatabase.JSON_ARRAY_STRING_PARAM);

            for(int i=0; i<jsonArray.length(); i++)
            {
                MovieModel md=new MovieModel();

                JSONObject jsonObjectMovie= jsonArray.getJSONObject(i);
                md.setId(jsonObjectMovie.getDouble(MovieDatabase.JSON_MOVIE_ID));
                md.setLanguage(jsonObjectMovie.getString(MovieDatabase.JSON_LANGUAGE));
                md.setMovieName(jsonObjectMovie.getString(MovieDatabase.JSON_MOVIE_NAME));
                md.setOverView(jsonObjectMovie.getString(MovieDatabase.JSON_OVERVIEW));
                md.setPosterPath(jsonObjectMovie.getString(MovieDatabase.JSON_POSTER_PATH));
                md.setRating(jsonObjectMovie.getDouble(MovieDatabase.JSON_RATING)+"");
                md.setReleaseDate(jsonObjectMovie.getString(MovieDatabase.JSON_RELEASE_DATE));

                ar.add(md);




            }
            return ar;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

}
