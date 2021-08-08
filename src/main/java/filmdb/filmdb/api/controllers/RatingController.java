package filmdb.filmdb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filmdb.filmdb.business.abstracts.RatingService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Rating;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

	private RatingService ratingService;

	@Autowired
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	@GetMapping("/getall")
	public DataResult<List<Rating>> getAll() {
		return this.ratingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Rating rating) {
		return this.ratingService.add(rating);
	}

}