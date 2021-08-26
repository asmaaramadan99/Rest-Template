package com.example.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.service.MovieService;


@RestController
@CrossOrigin
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/{movieName}")
	public String getMovieByName(@PathVariable(name ="movieName") String movieName)
	
	{
		return movieService.getMovie(movieName);
	}
	
	@GetMapping("/hi")
	public String get()
	
	{
		return "hi";
	}

}
