package filmdb.filmdb.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ratings")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","movie"})

public class Rating { 


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private Integer ratingId;

	@Column(name = "likes")
	private Integer likes;

	@Column(name = "dislike")
	private Integer dislike;

	@Column(name = "rating")
	private Double rating;

	@Column(name = "total_ratings")
	private Integer totalRatings;
	
	@OneToOne(mappedBy = "rating")
	private Movie movie;

}
