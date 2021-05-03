package com.cst438.assignment1;

import java.time.Instant;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieRatingsController {
	
	@Autowired
	MovieRatingRepository ratingRepository;
	
	// Display all movie ratings sorted by title and date
	@GetMapping("/movies")
	public String getAllRatings(Model model) {
		Iterable<MovieRating> ratings = ratingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("ratings", ratings);
		return "view_ratings";
	}
	
	// Validates submitted form, returns form if validation fails or stores new rating in database
	// and displays all movie ratings.
	@PostMapping("/movies/new")
	public String processRatingForm(@Valid MovieRating movieRating, BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			System.out.println(result);
			return "rating_form";
		}
		
		// Set rating date
		movieRating.setDate(Instant.now());
		ratingRepository.save(movieRating);
		
		Iterable<MovieRating> ratings = ratingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("ratings", ratings);
		return "view_ratings";
	}
	
	// Displays rating form
	@GetMapping("movies/new")
	public String getRating(Model model) {
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "rating_form";
	}

}
