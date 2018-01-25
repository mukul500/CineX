package net.backwings.cinex.Utils;

import android.util.Log;

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

    private  ArrayList<MovieModel> ar;
    private final static String TAG= GetArrayListFromJson.class.getSimpleName();

    public ArrayList<MovieModel> getList(String JSON)
    {

        try {
            ar=new ArrayList<MovieModel>();
            JSONObject jsonObject= new JSONObject(JSON);
        //    Log.e(TAG, "JSONObject ----> "+jsonObject);
            JSONArray jsonArray= jsonObject.getJSONArray(MovieDatabase.JSON_ARRAY_STRING_PARAM);
      //      Log.e(TAG, "JSON Array Found");

            for(int i=0; i<jsonArray.length(); i++)
            {
                MovieModel md=new MovieModel();
    //            Log.e(TAG, "First Array Model Found");
                JSONObject jsonObjectMovie= jsonArray.getJSONObject(i);
  //              Log.e(TAG, "JSONObject ----> "+jsonObjectMovie);
                md.setId(jsonObjectMovie.getDouble(MovieDatabase.JSON_MOVIE_ID));

//                Log.e(TAG, "<--- ID Found--->");

                md.setLanguage(jsonObjectMovie.getString(MovieDatabase.JSON_LANGUAGE));

                //Log.e(TAG, "<--- Language Found--->");
                md.setMovieName(jsonObjectMovie.getString(MovieDatabase.JSON_MOVIE_NAME));

               // Log.e(TAG, "<--- Movie Found--->");
                md.setOverView(jsonObjectMovie.getString(MovieDatabase.JSON_OVERVIEW));

               // Log.e(TAG, "<--- OverView Found--->");
                md.setPosterPath(jsonObjectMovie.getString(MovieDatabase.JSON_POSTER_PATH));

               // Log.e(TAG, "<--- Poster Found--->");
                md.setRating(jsonObjectMovie.getDouble(MovieDatabase.JSON_RATING)+"");

               // Log.e(TAG, "<--- Rating Found--->");
                md.setReleaseDate(jsonObjectMovie.getString(MovieDatabase.JSON_RELEASE_DATE));

             //   Log.e(TAG, "<--- Release Found--->" +md.getReleaseDate());

                ar.add(md);




            }
            return ar;

        } catch (JSONException e) {

            Log.e(TAG, e+"");
            e.printStackTrace();
            return null;

        }


    }

}
