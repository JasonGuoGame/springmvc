package com.helloword.rest;

import com.helloword.dto.MovieDTO;
import com.helloword.dto.PersonDTO;
import com.helloword.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by scnyig on 1/5/2018.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MovieDTO> list() {
        return movieService.findAll();
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public MovieDTO newMovie(MovieDTO movie) {
        movieService.save(movie);
        return movie;
    }

    @RequestMapping(value = "/{id:\\d+}.json",method = RequestMethod.GET)
    @ResponseBody
    public MovieDTO viewMovie(@PathVariable Integer id) {
        return movieService.findMovieById(id);
    }

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@PathVariable Integer id) {
        movieService.delMovie(id);
        return "success";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public String update(MovieDTO movie) {
        movieService.editMovie(movie);
        return "success";
    }
}
