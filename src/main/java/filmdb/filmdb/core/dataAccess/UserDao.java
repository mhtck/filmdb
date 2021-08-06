package filmdb.filmdb.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import filmdb.filmdb.core.entities.User;

public interface UserDao  extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	

}
