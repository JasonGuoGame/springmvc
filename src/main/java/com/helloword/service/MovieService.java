package com.helloword.service;

import com.helloword.dto.MovieDTO;

import java.util.List;

/**
 * Created by scnyig on 1/5/2018.
 */
public interface MovieService {
    public List<MovieDTO> findAll();
    public void save(MovieDTO movie);
    public MovieDTO findMovieById(Integer id);
    public MovieDTO delMovie(Integer id);
    public MovieDTO editMovie(MovieDTO movieDTO);
}
