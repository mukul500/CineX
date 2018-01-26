package net.backwings.cinex.Models;


public final class MovieDatabase {


    private static final String apiKey="";
    private static final String baseUrl="https://api.themoviedb.org/3";
    private static final String popularExtend="/movie/popular";
    private static final String highestRatedExtend="/movie/top_rated";
    private static final String baseUrlForPoster="http://image.tmdb.org/t/p/w185";
    private static final String basurlForBackDrop="http://image.tmdb.org/t/p/w500";


    public static final String JSON_ARRAY_STRING_PARAM="results";
    public static final String JSON_VOTE_COUNT="vote_count";
    public static final String JSON_MOVIE_NAME="title";
    public static final String JSON_OVERVIEW="overview";
    public static final String JSON_RELEASE_DATE="release_date";
    public static final String JSON_POSTER_PATH="poster_path";
    public static final String JSON_RATING="vote_average";
    public static final String JSON_LANGUAGE="original_language";
    public static final String JSON_MOVIE_ID="id";
    public static final String JSON_BACKDROP_PATH="backdrop_path";


    private static final String apiPar="api_key";

    public static String getApiKey()
    {
        return apiKey;
    }
    public static String getPopularUrl(){
        return baseUrl+popularExtend;
    }
    public static String getHighestRatedUrl(){
        return baseUrl+highestRatedExtend;
    }
    public static String getApiPar(){
        return apiPar;
    }
    public static String getPosterUrl(String imagePath)
    {
        return baseUrlForPoster+imagePath;
    }
    public static String getBackDropUrl(String imagePath){
        return basurlForBackDrop+imagePath;
    }

}
