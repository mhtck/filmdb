package filmdb.filmdb.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;

import filmdb.filmdb.business.abstracts.MovieService;
import filmdb.filmdb.core.exceptions.MovieNotFoundException;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.dataAccess.abstracts.MovieDao;
import filmdb.filmdb.entities.concretes.Movie;


@Service
public class MovieManager implements MovieService {

	private MovieDao movieDao;

	@Autowired
	Mapper dozerMapper;

	@Autowired
	public MovieManager(MovieDao movieDao) {
		super();
		this.movieDao = movieDao;
	}

	@Override
	public DataResult<List<Movie>> getAll() {
		return new SuccessDataResult<List<Movie>>(this.movieDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Movie movie) {
		this.movieDao.save(movie);
		return new SuccessResult("Film Eklendi");
	}

	public Result update(Movie movie) {
		Optional<Movie> foundMovie = movieDao.findById(movie.getMovieId());
		if (foundMovie.isPresent()) {
			foundMovie.get().setMovieName(movie.getMovieName());
			foundMovie.get().setReleaseYear(movie.getReleaseYear());
			movieDao.save(foundMovie.get());
			return new SuccessResult("Film Güncellendi.");
		}
		throw new MovieNotFoundException(movie.getMovieId());
	}

	@Override
	public DataResult<Movie> getByMovieName(String movieName) {
		return new SuccessDataResult<Movie>(this.movieDao.getByMovieName(movieName), "Data listelendi");
	}

	@Override
	public DataResult<List<Movie>> getByMovieNameOrCategory_CategoryId(String movieName, int categoryId) {
		return new SuccessDataResult<List<Movie>>(
				this.movieDao.getByMovieNameOrCategory_CategoryId(movieName, categoryId), "Data Listelendi");
	}

	@Override
	public Result delete(Integer id) {
		Optional<Movie> foundMovie = movieDao.findById(id);
		if (foundMovie.isPresent()) {
			movieDao.deleteById(id);
			return new SuccessDataResult<Movie>("Film Silindi!");
		}
		throw new MovieNotFoundException(id);
	}

	@Override
	public DataResult<List<Movie>> getMovietWithCategoryDetails(Integer categoryId) {
		return new SuccessDataResult<List<Movie>>(this.movieDao.getMovieWithCategoryDetails(categoryId), "Data Listelendi");
	}

	@Override
	public DataResult<List<Movie>> getMovietWithLanguage(Integer languageId) {
		return new SuccessDataResult<List<Movie>>(this.movieDao.getMovieWithLanguage(languageId), "Data Listelendi");
	}

}
