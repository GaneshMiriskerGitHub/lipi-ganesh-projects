package com.imdb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imdb.entity.Movie;

@RestController
public class MovieController {

    Map<Integer, Movie> movieMap = new HashMap<>();

    static int i = 0;

    @GetMapping("/")
    public String greetUser(@RequestParam("name") String name) {
        return "Hi "+"lipiee😊 "+ name;
    }
//    CRUD  - Create
    /*
    Create - add -to- DB
    READ  -  get
    Update - modify
    Delete - id remove
     */
    @PostMapping("movie/addMovie")
    public String addMovie(@RequestBody Movie movie) {
        i = i+1;
        int key = i;
        movie.setId(key);
        this.movieMap.put(key, movie);
        /*
                       2, ["2", "hinanna", "action, ""]
         */

        /*

         */
        return "movie successfully added";
    }

    @GetMapping("/movie/getAllMovies")
    public List<Movie> getALlMovies() {
        return this.movieMap.values().stream().toList();
    }

    @GetMapping("/movie/getMovieById")
    public Movie getMovieById(Integer id) {
        return this.movieMap.get(id);
    }

    @GetMapping("/movie/deleteById")
    public String  deleteMovieById(Integer id) {
        this.movieMap.remove(id);
        return "movie successfully deleted";
    }
    
    @PostMapping("/movie/updateMovie")
    public String updateMovie(@RequestBody Movie movie) {
    	
    	int did = movie.getId();
    	this.movieMap.remove(did);
    	this.movieMap.put(did, movie);
    	
    	return "movie details are successfully updated";
    	
    }

    @GetMapping("/movie/getMovieByTitle")
    public List<Movie> getMovieByTitle(String title) {
        List<Movie> result = this.movieMap.values().stream().filter(movie -> title.equals(movie.getTitle())).toList();
        return result;
    }
   


}
