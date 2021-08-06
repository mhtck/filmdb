package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Movie;
import filmdb.filmdb.entities.dtos.MovieDto;

public interface MovieService {

	DataResult<List<Movie>> getAll();
	
	Result add(Movie movie);
	
	Result update(MovieDto movieDto) ;
	
	Result delete(Integer id) ;
	
	DataResult<Movie> getByMovieName(String movieName);
	
	DataResult<List<Movie>> getByMovieNameOrCategory_CategoryId(String movieName, int categoryId);
	
	DataResult<List<MovieDto>> getMovietWithCategoryDetails();
	
	DataResult<List<MovieDto>> getMovietWithLanguage();


}
