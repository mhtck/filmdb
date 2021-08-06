package filmdb.filmdb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
