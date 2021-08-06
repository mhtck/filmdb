package filmdb.filmdb.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import filmdb.filmdb.entities.concretes.Movie;
import filmdb.filmdb.entities.dtos.MovieDto;

public interface MovieDao extends JpaRepository<Movie, Integer>{
	
	Movie getByMovieName(String movieName);
	
	List<Movie> getByMovieNameOrCategory_CategoryId(String movieName, int categoryName);
	
	List<Movie> getByMovieNameStartsWith(String movieName);
	
	@Query("Select new filmdb.filmdb.entities.dtos.MovieDto (m.movieId, m.movieName, c.categoryName) From Category c Inner Join c.movies m")
	List<MovieDto> getMovieWithCategoryDetails();
	
	@Query("Select new filmdb.filmdb.entities.dtos.MovieDto (m.movieId, m.movieName, m.releaseYear) From Language l Inner Join l.movies m")
	List<MovieDto> getMovieWithLanguage();
	
	
}
