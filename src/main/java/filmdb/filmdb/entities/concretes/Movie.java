package filmdb.filmdb.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Integer movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "release_year")
	private Integer releaseYear;

	@Column(name = "story")
	private String story;

	@Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "last_update_timestamp")
	private Date lastUpdateTimestamp;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "movie")
	private List<Review> reviews;

	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rating_id", referencedColumnName = "rating_id")
	private Rating rating;

}
