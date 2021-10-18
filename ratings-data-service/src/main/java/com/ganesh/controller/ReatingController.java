package com.ganesh.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Rating;
import com.ganesh.model.UserReating;

@RestController
@RequestMapping("/ratingsdata")
public class ReatingController {
	
	@RequestMapping("/{movieId}")
	public Rating getReating(@PathVariable("movieId")String movieId) {
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("users/{userId}")
	public UserReating getUserReating(@PathVariable("userId")String movieId) {
		 List<Rating> ratingsList = Arrays.asList(new Rating("1234", 4), new Rating("5678", 5));
		 UserReating userReating = new UserReating();
		 userReating.setRating(ratingsList);
		 return userReating;
	}

}
