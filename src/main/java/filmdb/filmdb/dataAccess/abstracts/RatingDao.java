package filmdb.filmdb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import filmdb.filmdb.entities.concretes.Rating;

public interface RatingDao extends JpaRepository<Rating, Integer>{

}
