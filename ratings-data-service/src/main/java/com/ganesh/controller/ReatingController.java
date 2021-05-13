package com.ganesh.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class ReatingController {
	
	@RequestMapping("/{movieId}")
	public Rating getReating(@PathVariable("movieId")String movieId) {
		return new Rating(movieId, 5);
	}

}
