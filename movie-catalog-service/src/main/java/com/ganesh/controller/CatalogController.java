package com.ganesh.controller;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ganesh.model.CatalogItem;
import com.ganesh.model.Movie;
import com.ganesh.model.Rating;
import com.ganesh.model.UserReating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		//return Collections.singletonList(new CatalogItem("Kick", "Action", 5));
	
		//UserReating ratings = restTemplate.getForObject("http://localhost:8003/ratingsdata/users/" + userId, UserReating.class);
		UserReating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserReating.class);
		
	///	return ratingsList.stream().map(rating -> new CatalogItem("Kick", "Action", 5)).collect(Collectors.toList());
	
		return ratings.getRating().stream().map(rating -> {
            //Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Description", rating.getRating());
        })
        .collect(Collectors.toList());
		
	}
}
