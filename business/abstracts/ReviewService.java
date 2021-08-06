package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Review;

public interface ReviewService {
	DataResult<List<Review>> getAll();
	Result add(Review review);
}
