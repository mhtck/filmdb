package filmdb.filmdb.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import filmdb.filmdb.entities.concretes.Movie;


public interface MovieDao extends JpaRepository<Movie, Integer>{
	
	Movie getByMovieName(String movieName);
	
	List<Movie> getByMovieNameOrCategory_CategoryId(String movieName, int categoryName);
	
	List<Movie> getByMovieNameStartsWith(String movieName);
	
	@Query("From Movie where category.categoryId=:categoryId")
	List<Movie> getMovieWithCategoryDetails(int categoryId);
	
	@Query("From Movie where language.languageId=:languageId")
	List<Movie> getMovieWithLanguage(int languageId);
	
	
}
