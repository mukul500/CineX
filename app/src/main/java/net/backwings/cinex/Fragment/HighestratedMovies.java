package net.backwings.cinex.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.backwings.cinex.Adapter.ViewAdapter;
import net.backwings.cinex.Loader.MovieDataLoader;
import net.backwings.cinex.Models.MovieModel;
import net.backwings.cinex.R;
import net.backwings.cinex.Utils.NetworkUtils;

import java.util.ArrayList;

/**
 * Created by mukul on 1/25/2018.
 */

public class HighestratedMovies extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<MovieModel>> {


    private ArrayList<MovieModel> ar;
    private RecyclerView rv;
    private ViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmanet_layout_movie, container, false);
        ar= new ArrayList<MovieModel>();
        rv= rootView.findViewById(R.id.rv_recyclerView);
        adapter=new ViewAdapter(getContext(),ar);
        rv.setAdapter(adapter);

        return rootView;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new MovieDataLoader(getContext(), NetworkUtils.HIGHEST_RATED_MOVIES_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<MovieModel>> loader, ArrayList<MovieModel> data) {


        if(data!=null)
        {
            ar.clear();
            ar.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onLoaderReset(Loader loader) {

    }
}
