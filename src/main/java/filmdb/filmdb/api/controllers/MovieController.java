package filmdb.filmdb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import filmdb.filmdb.business.abstracts.MovieService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Movie;


@RestController
@RequestMapping("/api/movies")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping("/getall")
	public DataResult<List<Movie>> getAll() {
		return this.movieService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Movie movie) {
		return this.movieService.add(movie);
	}

	@DeleteMapping("/delete{id}")
	public Result delete(@PathVariable Integer id) {
		return this.movieService.delete(id);
	}

	@PutMapping("/update")
	public Result delete(@RequestBody Movie movie) {
		return this.movieService.update(movie);
	}

	@GetMapping("/getByMovieName")
	public DataResult<Movie> getByMovieName(@RequestParam("movieName") String movieName) {
		return this.movieService.getByMovieName(movieName);
	}

	@GetMapping("/getByMovieNameOrCategoryId")
	public DataResult<List<Movie>> getByMovieNameOrCategoryId(@RequestParam("movieName") String movieName,
			@RequestParam("categoryId") int categoryId) {
		return this.movieService.getByMovieNameOrCategory_CategoryId(movieName, categoryId);
	}

	@GetMapping("/getMovieWithCategoryDetails")
	public DataResult<List<Movie>> getMovieWithCategoryDetails(@RequestParam("categoryId") Integer categoryId) {
		return this.movieService.getMovietWithCategoryDetails(categoryId);
	}

	@GetMapping("/getMovietWithLanguage")
	public DataResult<List<Movie>> getMovietWithLanguage(@RequestParam("languageId") Integer languageId) {
		return this.movieService.getMovietWithLanguage(languageId);
	}

}
