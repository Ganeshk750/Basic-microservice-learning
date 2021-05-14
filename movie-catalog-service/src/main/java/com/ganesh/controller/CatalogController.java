package com.ganesh.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.CatalogItem;
import com.ganesh.model.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		//return Collections.singletonList(new CatalogItem("Kick", "Action", 5));
		
		
		List<Rating> ratingsList = Arrays.asList(new Rating("1234", 4),
				                  new Rating("5678", 5));
		
		return ratingsList.stream().map(rating -> 
			    new CatalogItem("Kick", "Action", 5))
				.collect(Collectors.toList());
	}
}
