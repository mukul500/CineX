package net.backwings.cinex.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import net.backwings.cinex.Models.MovieDatabase;
import net.backwings.cinex.Models.MovieModel;
import net.backwings.cinex.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by mukul on 1/25/2018.
 */

public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private final String TAG= this.getClass().getSimpleName();

    ArrayList<MovieModel> arrayList;


    public  ViewAdapter(Context mContext, ArrayList<MovieModel> arrayList)
    {
        this.mContext=mContext;
        this.arrayList=arrayList;
    }


    @Override
    public int getItemViewType(int position) {
        if ((position + 1) % 4 == 0)
            return 1;
        else
            return 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        try{



            RecyclerView.ViewHolder viewHolder;
            if(viewType ==1)
            {
                View view= LayoutInflater.from(mContext).inflate(R.layout.layout_holder_large,parent,false);
                viewHolder= new ViewHolderLarge(view);

            }
            else{
                View view= LayoutInflater.from(mContext).inflate(R.layout.layout_holder_small,parent,false);
                viewHolder= new ViewHolderSmall(view);

            }
            return viewHolder;

        }
        catch (Exception e)
        {

            Log.e(TAG, e+"");
            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        try{


            MovieModel movieModel= arrayList.get(position);
            switch (getItemViewType(position))
            {
                case 2:
                {
                    ViewHolderSmall viewHolderSmall=(ViewHolderSmall) holder;

                    Glide.with(mContext).load(MovieDatabase.getPosterUrl(movieModel.getPosterPath())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(viewHolderSmall.getmImageView());

                    viewHolderSmall.getmTitleView().setText(movieModel.getMovieName());
                    break;

                }

                case 1:
                {
                    ViewHolderLarge viewHolderLarge= (ViewHolderLarge) holder;
                    Glide.with(mContext).load(MovieDatabase.getPosterUrl(movieModel.getPosterPath())).into(viewHolderLarge.getmImageView());
                    viewHolderLarge.getmDescriptionView().setText(movieModel.getOverView());
                    viewHolderLarge.getmTitleView().setText(movieModel.getMovieName());
                    break;


                }

            }


        }

        catch (Exception e)
        {
            Log.e(TAG,e+"");
        }





    }

    @Override
    public int getItemCount() {
       return  arrayList.size();
    }

    public class ViewHolderSmall extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitleView;

        public ViewHolderSmall(View itemView) {
            super(itemView);
            mImageView= itemView.findViewById(R.id.iv_image);
            mTitleView= itemView.findViewById(R.id.tv_title);

        }

        public TextView getmTitleView(){
            return mTitleView;
        }

        public ImageView getmImageView(){
            return mImageView;
        }


    }

    public  class ViewHolderLarge extends RecyclerView.ViewHolder
    {

        ImageView mImageView;
        TextView mTitleView,mDescriptionView;

        public ViewHolderLarge(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.iv_image);
            mTitleView= itemView.findViewById(R.id.tv_title);
            mDescriptionView=itemView.findViewById(R.id.tv_description);

        }

        public TextView getmTitleView(){
            return mTitleView;
        }
        public TextView getmDescriptionView(){
            return mDescriptionView;
        }

        public ImageView getmImageView(){
            return mImageView;
        }
    }
}
