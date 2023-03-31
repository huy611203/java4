package poly.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Favorites", uniqueConstraints = { @UniqueConstraint(columnNames = { "VideoId", "UserId" })

})
public class Favorites {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@ManyToOne
	@JoinColumn(name = "UserId")
	User user;
	@ManyToOne
	@JoinColumn(name = "VideoId")
	Video video;
	@Temporal(TemporalType.DATE)
	Date LikeDate = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikeDate() {
		return LikeDate;
	}

	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}

	public Favorites() {
		super();
	}

	public Favorites(long id, User user, Video video, Date likeDate) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		LikeDate = likeDate;
	}

}
