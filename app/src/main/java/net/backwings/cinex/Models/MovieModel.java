package net.backwings.cinex.Models;

/**
 * Created by mukul on 1/25/2018.
 */

public class MovieModel {

    private double id;
    private String movieName,overView,releaseDate,language,rating,posterPath;



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

}
