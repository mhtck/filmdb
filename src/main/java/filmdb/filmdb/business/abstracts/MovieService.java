package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Movie;


public interface MovieService {

	DataResult<List<Movie>> getAll();
	
	Result add(Movie movie);
	
	Result update(Movie movie) ;
	
	Result delete(Integer id) ;
	
	DataResult<Movie> getByMovieName(String movieName);
	
	DataResult<List<Movie>> getByMovieNameOrCategory_CategoryId(String movieName, int categoryId);
	
	DataResult<List<Movie>> getMovietWithCategoryDetails(Integer categoryId);
	
	DataResult<List<Movie>> getMovietWithLanguage(Integer languageId);


}
