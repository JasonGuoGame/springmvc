package com.helloword.repository;

import com.helloword.dto.MovieDTO;
import com.helloword.entity.Movie;
import com.helloword.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by scnyig on 1/5/2018.
 */
@Repository
@Qualifier(value = "movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public MovieDTO findMovieById(Long id);
}
