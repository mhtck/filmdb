package filmdb.filmdb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private Integer id;
	private String movieName;
	private Integer releaseYear;
	private String languageName;
}
