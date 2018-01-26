package net.backwings.cinex.Models;

import java.io.Serializable;



public class MovieModel implements Serializable{

    private double id;
    private String movieName,overView,releaseDate,language,rating,posterPath,backdropPath;



    public void setId(double id)
    {
        this.id=id;
    }
    public void setMovieName(String movieName)
    {
        this.movieName=movieName;
    }
    public void setOverView(String overView)
    {
        this.overView=overView;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate=releaseDate;
    }
    public void setLanguage(String language){
        this.language=language;
    }
    public void setPosterPath(String posterPath){
        this.posterPath=posterPath;
    }
    public void setRating(String rating){
        this.rating=rating;
    }

    public void setBackdropPath(String backdropPath){
        this.backdropPath=backdropPath;
    }


    public double getId(){
        return id;
    }
    public String getMovieName(){
        return  movieName;
    }

    public String getOverView(){
        return overView;
    }
    public String getReleaseDate(){
        return releaseDate;
    }
    public String getLanguage(){
        return language;
    }
    public String getRating(){
        return rating;
    }
    public String getPosterPath(){
        return posterPath;
    }
    public String getBackdropPath(){
        return backdropPath;
    }


}
