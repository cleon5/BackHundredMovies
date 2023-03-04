package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;

import java.util.List;

public interface HundredMovieDAO {
    List<Movie> allMovie();
    Movie movieId(int id);
    void saveMovie(Movie movie);
    void deleteMovie(int id);
}
