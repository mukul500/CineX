package net.backwings.cinex.Activity;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import net.backwings.cinex.Models.MovieDatabase;
import net.backwings.cinex.Models.MovieModel;
import net.backwings.cinex.R;

import org.w3c.dom.Text;

/**
 * Created by mukul on 1/26/2018.
 */

public class DetailActivity extends AppCompatActivity {
    private MovieModel md;
    private ImageView imageViewBackDrop,starRating;
    private Palette.PaletteAsyncListener paletteListener;
    private int lightVibrantColor,darkVibrantColor,mutedColor;
    private Toolbar toolbarMovieDetails;

    private LinearLayout borderLine;
    private TextView ratingValue;
    private TextView releaseDate;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private  final String TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        md= (MovieModel) getIntent().getSerializableExtra("movieModel");

        borderLine=findViewById(R.id.dividerLine);
        ratingValue=findViewById(R.id.starText);
        starRating=findViewById(R.id.star);

        ratingValue.setText(md.getRating());

        imageViewBackDrop= findViewById(R.id.backdrop);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar_layout_movie_details);
        TextView movieName= findViewById(R.id.movieName);
        movieName.setText(md.getMovieName());
        releaseDate= findViewById(R.id.releaseDate);
        releaseDate.setText(md.getReleaseDate());
        ImageView moviePoster= findViewById(R.id.poster);
        Glide.with(this).load(MovieDatabase.getPosterUrl(md.getPosterPath())).crossFade().into(moviePoster);
        TextView overView= findViewById(R.id.overView);
        overView.setText(md.getOverView());


        Glide.with(this).load(MovieDatabase.getBackDropUrl(md.getBackdropPath())).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageViewBackDrop.setImageBitmap(resource);
                Log.e(TAG, "ImageLoaded");
                generatePalette(resource);

            }
        });


        toolbarMovieDetails=findViewById(R.id.toolbar_movie_details);
        toolbarMovieDetails.setTitle(md.getMovieName());
       // setSupportActionBar(toolbarMovieDetails);
      //  getSupportActionBar().setTitle(md.getMovieName());



        paletteListener = new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
            //    Log.e(TAG, "Color Generated");
               lightVibrantColor= palette.getVibrantColor(getResources().getColor(R.color.white));

            ///    Log.e(TAG, "Color Light- "+lightVibrantColor);
               darkVibrantColor= palette.getDarkMutedColor(getResources().getColor(R.color.gray));

               mutedColor=palette.getDominantColor(getResources().getColor(R.color.mostDarkGrey));

             //   Log.e(TAG, "Color Dark- "+darkVibrantColor);
               changeColors();

            }
        };

    }

    public void changeColors(){
        borderLine.setBackgroundColor(lightVibrantColor);
        //toolbarMovieDetails.setBackgroundColor(darkVibrantColor);
        ratingValue.setTextColor(lightVibrantColor);
        releaseDate.setTextColor(lightVibrantColor);

        starRating.getDrawable().setColorFilter(lightVibrantColor, PorterDuff.Mode.MULTIPLY);
        collapsingToolbarLayout.setContentScrimColor(mutedColor);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(darkVibrantColor);
        }

    }

    public void generatePalette(Bitmap bmp)
    {
        Log.e(TAG,"GeneratePalette Called");
        Palette.from(bmp).generate(paletteListener);
    }
}
