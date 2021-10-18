package com.ganesh.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@RequestMapping("/{movieId}")
	public Movie getMoviesInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test Movie");
	}
}
