package filmdb.filmdb.core.exceptions;


@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(Integer id) {
		super(String.format("Kullanıcı Bulunamadı! (id = %s)", id));
	}

}
