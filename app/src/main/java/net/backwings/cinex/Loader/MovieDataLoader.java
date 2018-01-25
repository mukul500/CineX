package net.backwings.cinex.Loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

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
    private ArrayList<MovieModel> mData;
    private String TAG=this.getClass().getSimpleName();
    public MovieDataLoader(Context context, int urlType) {
        super(context);
        this.mContext=context;
        this.urlType=urlType;

    }

    @Override
    public ArrayList<MovieModel> loadInBackground() {

        try{

            NetworkUtils networkUtils=new NetworkUtils();


            Log.e(TAG, "Background Thread Started");
            URL url= networkUtils.getURL(urlType);

            Log.e(TAG, " URL=== "+url);
            String JSON= networkUtils.getResponseFromUrl(url);

            //Log.e(TAG,JSON);
            GetArrayListFromJson getArrayListFromJson=new GetArrayListFromJson();

           ArrayList<MovieModel> ar= getArrayListFromJson.getList(JSON);

          //  Log.e(TAG,ar+"");

            return ar;


        }
        catch (Exception e)
        {
            Log.e(TAG,e+"");
            return null;
        }


    }




    protected void onStartLoading(){
        if(mData!=null)
        {
            Log.e("No Background Task","Cached Data");
            deliverResult(mData);
        }
        else{
            Log.e("Loader Started ","Background Task");
            forceLoad();
        }
    }

    @Override
    public void deliverResult(ArrayList<MovieModel> data) {
        this.mData=data;
        super.deliverResult(data);
    }
}
