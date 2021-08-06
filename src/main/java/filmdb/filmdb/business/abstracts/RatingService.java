package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Rating;

public interface RatingService {
	DataResult<List<Rating>> getAll();
	Result add(Rating rating);
}
