package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Category;

public interface CategoryService {

	DataResult<List<Category>> getCategoryOfMovie();
	Result add(Category category);
}
