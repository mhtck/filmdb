package filmdb.filmdb.business.abstracts;

import filmdb.filmdb.core.entities.User;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.dtos.UserDto;

public interface UserService {

	Result add(User user);
	
	Result update(UserDto userDto) ;
	
	Result delete(Integer id) ;
	
	DataResult<User> findByEmail(String email);

}
