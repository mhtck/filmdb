package filmdb.filmdb.core.exceptions;


@SuppressWarnings("serial")
public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(Integer id) {
		super(String.format("Film Bulunamadı! (id = %s)", id));
	}

}
