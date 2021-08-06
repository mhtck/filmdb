package filmdb.filmdb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmdb.filmdb.business.abstracts.CategoryService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.dataAccess.abstracts.CategoryDao;
import filmdb.filmdb.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getCategoryOfMovie() {
		return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(),"Data listelendi");

	}

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult("Kategory Eklendi");
	}

}
