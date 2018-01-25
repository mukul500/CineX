package net.backwings.cinex.Utils;

import android.net.Uri;

import net.backwings.cinex.Models.MovieDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mukul on 1/25/2018.
 */

public final class NetworkUtils {

    public static final int POPULAR_MOVIE_URL=0,HIGHEST_RATED_MOVIES_URL=1;


    public static URL getURL(int urlType)
    {

        Uri.Builder builtUri=null;

        if(urlType == POPULAR_MOVIE_URL)
        {
           builtUri = Uri.parse(MovieDatabase.getPopularUrl()).buildUpon();
        }
        else if(urlType==HIGHEST_RATED_MOVIES_URL)
        {
            builtUri= Uri.parse(MovieDatabase.getHighestRatedUrl()).buildUpon();

        }

      Uri uri=  builtUri.appendQueryParameter(MovieDatabase.getApiPar(), MovieDatabase.getApiKey()).build();


        try{
            URL url=new URL(uri.toString());
            return url;

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getResponseFromUrl(URL url)
    {
        StringBuilder mStringBuilderJSON=new StringBuilder();
        InputStream mInputStream;
        InputStreamReader mInputStreamReader;
        BufferedReader mBufferedReader;
        String JSON;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            mInputStream=urlConnection.getInputStream();

            mInputStreamReader= new InputStreamReader(mInputStream);
            mBufferedReader= new BufferedReader(mInputStreamReader);
            JSON=mBufferedReader.readLine();
            while(JSON!=null)
            {
                mStringBuilderJSON.append(JSON);
                JSON=mBufferedReader.readLine();
            }

            return JSON;



        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

}
