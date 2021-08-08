package filmdb.filmdb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Data
@AllArgsConstructor

public class MovieDto {
	private Integer id;
	private String movieName;
	private Integer releaseYear;
  

	private String languageName;

	private Integer categoryId;
	private Integer languageId;

}
