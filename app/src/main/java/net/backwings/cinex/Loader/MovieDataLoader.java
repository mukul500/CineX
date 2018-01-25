package net.backwings.cinex.Loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import net.backwings.cinex.Models.MovieModel;
import net.backwings.cinex.Utils.GetArrayListFromJson;
import net.backwings.cinex.Utils.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mukul on 1/25/2018.
 */

public class MovieDataLoader extends AsyncTaskLoader<ArrayList<MovieModel>> {
    private int urlType;
    private Context mContext;
    private ArrayList<MovieModel> ar;
    public MovieDataLoader(Context context, int urlType) {
        super(context);
        this.mContext=context;
        this.urlType=urlType;

    }

    @Override
    public ArrayList<MovieModel> loadInBackground() {
       URL url= NetworkUtils.getURL(urlType);

       String JSON= NetworkUtils.getResponseFromUrl(url);

       ar= GetArrayListFromJson.getList(JSON);

       return ar;

    }
}
