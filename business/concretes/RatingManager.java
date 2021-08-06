package filmdb.filmdb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmdb.filmdb.business.abstracts.RatingService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.dataAccess.abstracts.RatingDao;
import filmdb.filmdb.entities.concretes.Rating;

@Service
public class RatingManager implements RatingService{
	private RatingDao ratingDao;
	
	@Autowired
	public RatingManager(RatingDao ratingDao) {
		super();
		this.ratingDao = ratingDao;
	}

	@Override
	public DataResult<List<Rating>> getAll() {
		return new SuccessDataResult<List<Rating>>(this.ratingDao.findAll(),"Data listelendi");

	}

	@Override
	public Result add(Rating rating) {
		this.ratingDao.save(rating);
		return new SuccessResult("Rating Eklendi");
	}
}
