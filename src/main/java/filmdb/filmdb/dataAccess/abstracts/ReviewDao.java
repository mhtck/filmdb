package filmdb.filmdb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import filmdb.filmdb.entities.concretes.Review;

public interface ReviewDao extends JpaRepository<Review, Integer>{

}
