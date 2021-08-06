package filmdb.filmdb.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmdb.filmdb.business.abstracts.UserService;
import filmdb.filmdb.core.dataAccess.UserDao;
import filmdb.filmdb.core.entities.User;
import filmdb.filmdb.core.exceptions.UserNotFoundException;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.entities.dtos.UserDto;


@Service
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı Bulundu");
	}

	@Override
	public Result delete(Integer id)  {
		Optional<User> foundMovie = userDao.findById(id);
		if(foundMovie.isPresent()) {
			userDao.deleteById(id);
			return new SuccessDataResult<User>( "Kullanıcı Silindi!");
		}
		throw new UserNotFoundException(id);
	}

	@Override
	public Result update(UserDto userDto)  {
		Optional<User> foundMovie = userDao.findById(userDto.getId());
		if (foundMovie.isPresent()) {
			foundMovie.get().setFirstName(userDto.getFirstName());
			foundMovie.get().setLastName(userDto.getLastName());
			foundMovie.get().setEmail(userDto.getEmail());
			foundMovie.get().setPassword(userDto.getPassword());
			userDao.save(foundMovie.get());
			return new SuccessResult("Kullanıcı Güncellendi");
		}
		throw new UserNotFoundException(userDto.getId());
	}

	

}
