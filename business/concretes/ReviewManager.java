package filmdb.filmdb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmdb.filmdb.business.abstracts.ReviewService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.dataAccess.abstracts.ReviewDao;
import filmdb.filmdb.entities.concretes.Review;

@Service
public class ReviewManager implements ReviewService{
	private ReviewDao reviewDao;
	
	@Autowired
	public ReviewManager(ReviewDao reviewDao) {
		super();
		this.reviewDao = reviewDao;
	}

	@Override
	public DataResult<List<Review>> getAll() {
		return new SuccessDataResult<List<Review>>(this.reviewDao.findAll(),"Data listelendi");

	}

	@Override
	public Result add(Review review) {
		this.reviewDao.save(review);
		return new SuccessResult("Yorum Eklendi");
	}
}
