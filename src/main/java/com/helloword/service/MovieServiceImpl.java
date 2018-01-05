package com.helloword.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.helloword.dto.MovieDTO;
import com.helloword.entity.Movie;
import com.helloword.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by scnyig on 1/5/2018.
 */
@Service
@Qualifier("movieService")
public class MovieServiceImpl implements MovieService {
    @Qualifier("movieRepository")
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDTO> findAll() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>(movieList.size());
        for (Movie movie : movieList) {
            MovieDTO movieDTO = new MovieDTO();
            BeanUtils.copyProperties(movie,movieDTO);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    @Override
    public void save(MovieDTO movieDTO) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);
        Movie save = movieRepository.save(movie);

    }

    @Override
    public MovieDTO findMovieById(Integer id) {
        Long longid = new Long(id);
        Optional<Movie> movie = movieRepository.findById(longid);
        MovieDTO movieDTO = new MovieDTO();
        BeanUtils.copyProperties(movie, movieDTO);
        return movieDTO;
    }

    @Override
    public MovieDTO delMovie(Integer id) {
        Long longid = new Long(id);
        movieRepository.deleteById(longid);
        return null;
    }

    @Override
    public MovieDTO editMovie(MovieDTO movieDTO) {
        return null;
    }


}
