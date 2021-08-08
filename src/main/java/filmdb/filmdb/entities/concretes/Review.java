package filmdb.filmdb.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import filmdb.filmdb.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reviews")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","movie"})

public class Review { //reviews = yorumlar

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Integer reviewId;

	@Column(name = "comments")
	private String comments;

	@Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne()
    @JoinColumn(name="movie_id")
    private Movie movie;

}