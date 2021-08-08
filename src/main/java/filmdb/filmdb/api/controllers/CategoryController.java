package filmdb.filmdb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filmdb.filmdb.business.abstracts.CategoryService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Category;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping("/getall")
	public DataResult<List<Category>> getAll() {
		return this.categoryService.getCategoryOfMovie();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Category category) {
		return this.categoryService.add(category);
	}

}