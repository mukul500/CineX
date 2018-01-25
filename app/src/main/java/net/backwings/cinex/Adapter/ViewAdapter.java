package net.backwings.cinex.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

    private ArrayList<MovieModel> arrayList;


    public  ViewAdapter(Context mContext, ArrayList<MovieModel> arrayList)
    {
        this.mContext=mContext;
        this.arrayList=arrayList;
    }


    @Override
    public int getItemViewType(int position) {
        if ((position + 1) % 4 == 0)
            return 1;

        else if((position + 1)% 2 == 0)
        {
            return 3;
        }

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
           /* else if(viewType ==3)
            {

                View view= LayoutInflater.from(mContext).inflate(R.layout.layout_holder_small_middle,parent,false);
                viewHolder= new ViewHolderSmall(view);
            }
             */
            else{
                View view= LayoutInflater.from(mContext).inflate(R.layout.layout_holder_small,parent,false);
                ViewHolderSmall smallHolder= new ViewHolderSmall(view);


                if(viewType==3)
                {
                    GridLayoutManager.LayoutParams layoutParams= (GridLayoutManager.LayoutParams) smallHolder.getFrameLayout().getLayoutParams();
                    layoutParams.setMargins(0,layoutParams.topMargin,0,layoutParams.bottomMargin);
                    smallHolder.getFrameLayout().setLayoutParams(layoutParams);
                }
                viewHolder=smallHolder;

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

                case 1:
                {
                    ViewHolderLarge viewHolderLarge= (ViewHolderLarge) holder;
                    Glide.with(mContext).load(MovieDatabase.getPosterUrl(movieModel.getPosterPath())).into(viewHolderLarge.getmImageView());
                    viewHolderLarge.getmDescriptionView().setText(movieModel.getOverView());
                    viewHolderLarge.getmTitleView().setText(movieModel.getMovieName());
                    break;


                }

                default:
                {
                    ViewHolderSmall viewHolderSmall=(ViewHolderSmall) holder;


                    Glide.with(mContext).load(MovieDatabase.getPosterUrl(movieModel.getPosterPath())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(viewHolderSmall.getmImageView());


                    viewHolderSmall.getmTitleView().setText(movieModel.getMovieName());


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

    public static class ViewHolderSmall extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitleView;
        FrameLayout frameLayout;

        protected ViewHolderSmall(View itemView) {
            super(itemView);
            mImageView= itemView.findViewById(R.id.iv_image);
            mTitleView= itemView.findViewById(R.id.tv_title);
            frameLayout=itemView.findViewById(R.id.layout_holder_small_cordinator_layout);

        }

        public TextView getmTitleView(){
            return mTitleView;
        }

        public ImageView getmImageView(){
            return mImageView;
        }
        public FrameLayout getFrameLayout(){
            return frameLayout;
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
