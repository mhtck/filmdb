package filmdb.filmdb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {
	private Integer id;
	private String movieName;
	private Integer releaseYear;
	private Integer categoryId;
	private Integer languageId;
}
