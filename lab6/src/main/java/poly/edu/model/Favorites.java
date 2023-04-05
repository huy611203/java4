package poly.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="Favorites")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorites f")
public class Favorites implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private Date likeDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private Users user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoId")
	private Videos video;

	public Favorites() {
	}

	public Favorites(long id, Date likeDate, Users user, Videos video) {
		super();
		this.id = id;
		this.likeDate = likeDate;
		this.user = user;
		this.video = video;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Videos getVideo() {
		return this.video;
	}

	public void setVideo(Videos video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", likeDate=" + likeDate + ", user=" + user + ", video=" + video + "]";
	}

}