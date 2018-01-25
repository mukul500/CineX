package net.backwings.cinex.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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
    private GridLayoutManager mGridLayoutManager;
    private ProgressBar mProgressBar;
    private final String TAG= this.getClass().getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmanet_layout_movie, container, false);
        ar= new ArrayList<MovieModel>();
        rv= rootView.findViewById(R.id.rv_recyclerView);


        mGridLayoutManager = new GridLayoutManager(getActivity(), 3);

        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position + 1) % 4 == 0)
                    return 3;
                else
                    return 1;
            }
        });
        rv.setLayoutManager(mGridLayoutManager);

        adapter=new ViewAdapter(getContext(),ar);
        rv.setAdapter(adapter);

       getLoaderManager().initLoader(0,null,this).startLoading();

        mProgressBar= rootView.findViewById(R.id.pb_progress_bar);

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
            Log.e(TAG,"Recieved Data");
            mProgressBar.setVisibility(View.GONE);
        }
        else{
            Log.e(TAG, "Data is Null");
        }
    }


    @Override
    public void onLoaderReset(Loader loader) {

    }
}
