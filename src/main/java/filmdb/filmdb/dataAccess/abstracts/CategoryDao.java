package filmdb.filmdb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import filmdb.filmdb.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	
}
